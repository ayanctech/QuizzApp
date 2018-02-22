package com.actech.jidanpc.quizproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class score extends AppCompatActivity {
    String classMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent=getIntent();
        classMsg = intent.getStringExtra("RootClassMsg");
        int SCORE_FINAL=intent.getIntExtra("score",0);



        Toast.makeText(getApplicationContext(),"The parent Category is "+classMsg,Toast.LENGTH_LONG).show();

        TextView textView=(TextView) findViewById(R.id.txScr);
        textView.setText("Your Final Score is-> " +SCORE_FINAL);
    }

    public void goCatg(View view) {
        Intent intent=new Intent(getApplicationContext(),Category.class);
        startActivity(intent);
    }

    public void goHome(View view) throws ClassNotFoundException {
        Intent intent1 = new Intent(this,chsRndm.class);
        intent1.putExtra("Message",classMsg);
        startActivity(intent1);
    }

    @Override
    public void onBackPressed() {

    }
}
