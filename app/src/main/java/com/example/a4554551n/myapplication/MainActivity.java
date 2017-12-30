package com.example.a4554551n.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<Questions> questionList;
    int score = 0;
    int questionID = 0;

    Questions currentQuestion;
    TextView txtQuestion;
    RadioButton rbtnA, rbtnB, rbtnC, rbtnD;
    Button btnNext;
   // ListView ListT;
//    Random r;
//    private int quLength=currentQuestion.getQuestion().length();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // r = new Random();
        DBQuiz dba = new DBQuiz(this);
        questionList = dba.getAllQuestions();
        questionList.get(new Random().nextInt(questionList.size()));
        currentQuestion = questionList.get(questionID);


        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        rbtnA = (RadioButton) findViewById(R.id.rtbOptionA);
        rbtnB = (RadioButton) findViewById(R.id.rtbOptionB);
        rbtnC = (RadioButton) findViewById(R.id.rtbOptionC);
        rbtnD = (RadioButton) findViewById(R.id.rtbOptionD);
        btnNext = (Button) findViewById(R.id.btnNext);
       // txtQuestion.setText("WTF");
        setQuestionView();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioGroup grp = (RadioGroup) findViewById(R.id.radiogroup1);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                grp.clearCheck();
                Log.d("yourans", currentQuestion.getAnswer()+ " " +answer.getText());
                if (currentQuestion.getAnswer().equals(answer.getText())){
                    score++;
                    Log.d("score ", "you score "+score);
                }
                if (questionID<5){
                    currentQuestion = questionList.get(questionID);
                    setQuestionView();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score",score);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
                }

        });

   }

    private void setQuestionView() {
        txtQuestion.setText(currentQuestion.getQuestion());
        rbtnA.setText(currentQuestion.getOptionA());
        rbtnB.setText(currentQuestion.getOptionB());
        rbtnC.setText(currentQuestion.getOptionC());
        rbtnD.setText(currentQuestion.getOptionD());
        questionID++;
    }
}
