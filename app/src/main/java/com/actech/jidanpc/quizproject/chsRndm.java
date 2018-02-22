package com.actech.jidanpc.quizproject;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.*;

public class chsRndm extends AppCompatActivity {
    String message="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chs_rndm);
        Intent intent=getIntent();

        message = intent.getStringExtra("Message");

        makeText(getApplicationContext(),message, LENGTH_LONG).show();
    }

    public void cQsn(View view){

        LayoutInflater layoutInflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        final View vw=layoutInflater.inflate(R.layout.popup_sel2,null);

        PopupWindow popupWindow=new PopupWindow(vw, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.showAtLocation(vw, Gravity.CENTER,0,0);;


        Button button5=(Button) vw.findViewById(R.id.btonv1);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nos=5;
                Class clss= null;
                try {
                    clss = Class.forName("com.actech.jidanpc.quizproject."+message.trim());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent intent1 = new Intent(chsRndm.this,Rndm.class);
                intent1.putExtra("Msg",message);
                intent1.putExtra("no_of_qsns",nos);
                startActivity(intent1);


            }
        });

        Button button10=(Button) vw.findViewById(R.id.btonv2);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nos=10;
                Class clss= null;
                try {
                    clss = Class.forName("com.actech.jidanpc.quizproject."+message);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent intent1 = new Intent(chsRndm.this,Rndm.class);
                intent1.putExtra("Msg",message);
                intent1.putExtra("no_of_qsns",nos);
                startActivity(intent1);
            }
        });

        Button button15=(Button) vw.findViewById(R.id.btonv3);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nos=15;
                Class clss= null;
                try {
                    clss = Class.forName("com.actech.jidanpc.quizproject."+message);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent intent1 = new Intent(chsRndm.this,Rndm.class);
                intent1.putExtra("Msg",message);
                intent1.putExtra("no_of_qsns",nos);
                startActivity(intent1);
            }
        });





        /*   Class clss=Class.forName("com.actech.jidanpc.quizproject."+message);
        Intent intent1 = new Intent(chsRndm.this,clss);
        startActivity(intent1);*/

    }


    public void tmrQsn(View view) {

        LayoutInflater layoutInflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        final View vw=layoutInflater.inflate(R.layout.popup_sel1,null);

        PopupWindow popupWindow=new PopupWindow(vw, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.showAtLocation(vw, Gravity.CENTER,0,0);;


        Button button5=(Button) vw.findViewById(R.id.bton1);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),TimerRndm.class);
                intent.putExtra("Msg",message);
                startActivity(intent);
            }
        });

        Button button10=(Button) vw.findViewById(R.id.bton2);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),TimerRndm.class);
                intent.putExtra("Msg",message);
                startActivity(intent);
            }
        });

        Button button15=(Button) vw.findViewById(R.id.bton3);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),TimerRndm.class);
                intent.putExtra("Msg",message);
                startActivity(intent);
            }
        });





       /* Intent intent=new Intent(getApplicationContext(),TimerRndm.class);
        intent.putExtra("Msg",message);
        startActivity(intent);*/
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(getApplicationContext(),Category.class));
    }
}
