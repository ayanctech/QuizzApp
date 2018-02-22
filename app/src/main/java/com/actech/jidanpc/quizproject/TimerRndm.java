package com.actech.jidanpc.quizproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;

public class TimerRndm extends AppCompatActivity {
    public int cntr=0;
    int tot_score=0;
    String lyoutMsg="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();

        lyoutMsg = intent.getStringExtra("Msg");

        setContentView(R.layout.activity_timer_rndm);

            new CountDownTimer(10000,1000) {
                @Override
                public void onTick(long l) {
                    TextView tv=(TextView) findViewById(R.id.tmr);
                    tv.setText(String.valueOf(cntr));
                    cntr+=1;
                }

                @Override
                public void onFinish() {
                    Intent intent=new Intent(getApplicationContext(),score.class);
                   intent.putExtra("score",tot_score);
                    intent.putExtra("RootClassMsg",lyoutMsg);
                    startActivity(intent);
                }
            }.start();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Go Back Alert!!");
        alertDialog.setMessage("Do you want to Really quit the Quiz!?").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent1 =new Intent(getApplicationContext(),chsRndm.class);
                intent1.putExtra("Message",lyoutMsg);
                startActivity(intent1);
            }
        }).setNegativeButton("Cancel",null);

        AlertDialog alert=alertDialog.create();
        alert.show();
    }
}
