package com.example.uzzal.wordgamming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv_info, tv_word;
    EditText et_guses;
    Button btn_check, btn_new;

    Random r;
    String currentWord;

    String[]  dictonary = {
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten"


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_info =(TextView) findViewById(R.id.tv_info);
        tv_word =(TextView) findViewById(R.id.tv_word);

        et_guses = (EditText)findViewById(R.id.et_guess);

        btn_check = (Button) findViewById(R.id.b_check);
        btn_new = (Button) findViewById(R.id.b_new);
        r = new Random();
        newGame();


        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et_guses.getText().toString().equalsIgnoreCase(currentWord)){
                    tv_info.setText("Awesome ...!");
                    btn_check.setEnabled(false);
                    btn_new.setEnabled(true);
                }else {
                    tv_info.setText("  try again please  ");
                }

            }
        });


        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newGame();
            }
        });



    }

     // shuffle algoritham.........!

    private  String shuffleWord(String word){

        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled  = "";
        for(String letter : letters){
            shuffled += letter;
        }
        return shuffled;
    }

    private void newGame(){


        // get random void from the dictonary.........!
        currentWord = dictonary[r.nextInt(dictonary.length)];

        //show the shuffle word..........!
        tv_word.setText(shuffleWord(currentWord));

         //clear the text file....!
        et_guses.setText("");
        btn_new.setEnabled(false);
        btn_check.setEnabled(true);
    }


}
