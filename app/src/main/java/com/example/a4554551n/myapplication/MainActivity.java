package com.example.a4554551n.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button anwers1,anwers2,anwers3,anwers4;
    TextView score,question;

    private Questions mQuestion = new Questions();

    private String mAnwer;
    private int mScore = 0;
    private int mQuestionsLenght = mQuestion.mQuestions.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        anwers1 = (Button)findViewById(R.id.anwers1);
        anwers2 = (Button)findViewById(R.id.anwers2);
        anwers3 = (Button)findViewById(R.id.anwers3);
        anwers4 = (Button)findViewById(R.id.anwers4);

        score = (TextView) findViewById(R.id.scroe);
        question = (TextView) findViewById(R.id.question);

        updateQuestion(r.nextInt(mQuestionsLenght));

        anwers1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        anwers2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        anwers3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        anwers4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void updateQuestion(int num){
        question.setText(mQuestion.getQuestions(num));
        anwers1.setText(mQuestion.getChoices1(num));
        anwers2.setText(mQuestion.getChoices2(num));
        anwers3.setText(mQuestion.getChoices3(num));
        anwers4.setText(mQuestion.getChoices4(num));

        mAnwer = mQuestion.getCorrecAnwer(num);

    }
}
