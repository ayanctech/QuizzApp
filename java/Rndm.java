package com.example.android.quizzproject;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.android.quizzproject.SetQuestions;
import java.util.ArrayList;
import java.util.Random;

public class Rndm extends AppCompatActivity {

    int tot_score=0;
    int count=0;
    Random rnd=new Random();
    public int i=rnd.nextInt(10)+1;

    boolean isQsetTurnedAround;

    // int i=0;
    TextView textView_question;
    TextView textView_answer;
    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    ArrayList<questions> questionsArrayList;

    String catgMsg="";
    int nos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rndm);

        Intent intent=getIntent();
        nos=intent.getIntExtra("no_of_qsns",10);
        catgMsg=intent.getStringExtra("Msg");

        i=rnd.nextInt(nos);

        Toast.makeText(getApplicationContext(),"No of Questions->" +nos,Toast.LENGTH_SHORT).show();

        textView_question = (TextView) findViewById(R.id.textview_question);
        textView_answer = (TextView) findViewById(R.id.textview_answer);
        radioGroup = (RadioGroup) findViewById(R.id.radgrp);
        radioButton1 = (RadioButton) findViewById(R.id.radiobutton_1);
        radioButton2 = (RadioButton) findViewById(R.id.radiobutton_2);
        radioButton3 = (RadioButton) findViewById(R.id.radiobutton_3);
        radioButton4 = (RadioButton) findViewById(R.id.radiobutton_4);
        questionsArrayList = new ArrayList<questions>();








        //**********************************


        //My First and foremost task will be to use this one java file/activity only to create quiz of different domain
        //using the if block by checking the intent message sent from the chsRndm.class
        //String str=intent.getStringExtra("Message");
        //if(str==Rndm){
        //(Add those category questions in the questionsarrayList)    }
        //and so on.....



        //**********************************
        Toast.makeText(getApplicationContext(), catgMsg, Toast.LENGTH_LONG).show();





        SetQuestions.setQsns(textView_question,radioButton1, radioButton2,radioButton3, radioButton4,catgMsg,this, questionsArrayList,nos,count, i, tot_score);
        // Toast.makeText(getApplicationContext(), qsn, Toast.LENGTH_LONG).show();

    }

    public void Submit(View view) {

        RadioGroup radioGroup2=(RadioGroup) findViewById(R.id.radgrp);
        int ridg=radioGroup2.getCheckedRadioButtonId();
        RadioButton rad=(RadioButton) findViewById(ridg);
        if(rad!=null){
            String ans=rad.getText().toString();
            String Real_ans=questionsArrayList.get(i).getAnswer();
            if(ans==Real_ans) {
                tot_score += 3;
                Toast.makeText(getApplicationContext(), "Well Done!!", Toast.LENGTH_SHORT).show();
            }
            else{
                tot_score -=1;
                Toast.makeText(getApplicationContext(), "Wrong Answewr", Toast.LENGTH_SHORT).show();
            }

        }
        else
            Toast.makeText(getApplicationContext(), "Oh You Did Not Attempt Any!!!", Toast.LENGTH_SHORT).show();
        if(i<10) {
            i += 1;
            radioGroup.clearCheck();

            //setQsns(i);
        }
        else if(i==10){
            if(count==nos) {
                Intent intent = new Intent(getApplicationContext(), score.class);
                intent.putExtra("score", tot_score);
                intent.putExtra("RootClassMsg", "Rndm");
                startActivity(intent);
            }
            else {
                i = 0;
                isQsetTurnedAround = true;
            }
        }
    }


    public void prev(View view) {
        if(i>1) {
            i -= 1;
            radioGroup.clearCheck();

            //setQsns(i);
        }
        else if(isQsetTurnedAround==true){
            i=10;
        }
        else{
            if(count==nos)
                Toast.makeText(getApplicationContext(), "No Where to Go Now!!", Toast.LENGTH_SHORT).show();
        }

    }

    public void next(View view) {
        if(i<10) {
            i += 1;
            radioGroup.clearCheck();

            //setQsns(i);
        }
        else{
            if(count==nos) {
                Intent intent = new Intent(getApplicationContext(), score.class);
                intent.putExtra("score", tot_score);
                intent.putExtra("RootClassMsg", "Rndm");
                startActivity(intent);
            }
            else {
                i = 0;
                isQsetTurnedAround = true;
            }
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Go Back Alert!!");
        alertDialog.setMessage("Do you want to Really quit the Quiz!?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent1 =new Intent(getApplicationContext(),chsRndm.class);
                intent1.putExtra("Message","Rndm");
                startActivity(intent1);
            }
        }).setNegativeButton("Cancel",null);

        AlertDialog alert=alertDialog.create();
        alert.show();
    }
}
