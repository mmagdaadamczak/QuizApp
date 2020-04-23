package com.example.asus.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    int points = 0;


    EditText text;
    String name;
    Button submitButton;
    Button scoreButton;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;
    RadioButton radio5;
    RadioButton radio6;
    RadioButton radio7;
    RadioButton radio8;
    CheckBox checkbox1;
    CheckBox checkbox2;
    CheckBox checkbox3;
    CheckBox checkbox4;


    //Array List of corrects answers
    String answer;
    ArrayList<String> answers = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Creating a textfield
        text = findViewById(R.id.name_field);



        //Setting a ClickListener on submit button

        submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = text.getText().toString();

                //Starting an e-mail intent with name from user, points and corect answers

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); //
                intent.putExtra(Intent.EXTRA_SUBJECT, "Player name: " + name);
                intent.putExtra(Intent.EXTRA_TEXT, "Your score: " + points +
                        "\nYour corect answers: " + "\n" + answers + "\n Congratulations!");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }


            }
        });

    //Setting a Listener on score button to show score in Toast
        scoreButton = findViewById(R.id.score_button);
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GameActivity.this, "Your score: " + points, Toast.LENGTH_SHORT).show();
            }
        });


    }



    //Question 1- Check if questions are correct and return an answer, only if it is correct
    public void onRadioButtonClicked(View view) {


        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);


        // Check which radio button was clicked

        answer = checkButton(radio1, radio2);
        answers.add(answer);


    }

    //Question 2- Check if questions are correct and return an answer, only if it is correct

    public void onRadioButtonClicked2(View view) {

        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);
        answer = checkButton(radio3, radio4);
        answers.add(answer);

    }

    //Question 3- Check if questions are correct and return an answer, only if it is correct
    public void onRadioButtonClicked3(View view) {

        radio5 = findViewById(R.id.radio5);
        radio6 = findViewById(R.id.radio6);
        answer = checkButton(radio6, radio5);
        answers.add(answer);

    }

    //Question 4- Check if questions are correct and return an answer, only if it is correct
    public void onRadioButtonClicked4(View view) {

        radio7 = findViewById(R.id.radio7);
        radio8 = findViewById(R.id.radio8);
        answer = checkButton(radio8, radio7);
        answers.add(answer);

    }


//This method check if user chose a correct answer

    public void onCheckboxClicked(View view) {

        checkbox1 = findViewById(R.id.checkbox_1);
        checkbox2 = findViewById(R.id.checkbox_2);
        checkbox3 = findViewById(R.id.checkbox_3);
        checkbox4 = findViewById(R.id.checkbox_4);


        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        String answer;
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_1:
                if (checked) {
                    points++;
                    checkbox1.setEnabled(false);
                    answer = checkbox1.getText().toString();
                    answers.add(answer);
                } else {
                    checkbox1.setEnabled(true);
                }
                break;

            case R.id.checkbox_2:
                if (checked) {
                    checkbox2.setEnabled(false);
                } else {
                    checkbox2.setEnabled(true);

                }
                break;

            case R.id.checkbox_3:
                if (checked) {
                    checkbox3.setEnabled(false);
                } else {
                    checkbox3.setEnabled(true);

                }
                break;

            case R.id.checkbox_4:
                if (checked) {
                    points++;
                    checkbox4.setEnabled(false);
                    answer = checkbox1.getText().toString();
                    answers.add(answer);
                } else {
                    checkbox4.setEnabled(true);

                }
                break;
        }
    }


    /**
     * Create summary of the order
     *
     * @param button1 first radiobutton
     *@param button2 second radiobutton
     */

    public String checkButton(RadioButton button1, RadioButton button2) {

        String message;


        if (button1.isChecked()) {
            points++;
            button1.setEnabled(false);
            button2.setEnabled(false);
            message = button1.getText().toString();

        } else {
            button1.setEnabled(false);
            button2.setEnabled(false);
            message = "";
        }

        return message;
    }




}











