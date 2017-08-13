package com.example.android.quizzproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }

    public void rndm(View view) {
        Intent intent=new Intent(getApplicationContext(),chsRndm.class);
        intent.putExtra("Message","Rndm");
        startActivity(intent);
    }

    public void tcng(View view) {
        Intent intent=new Intent(getApplicationContext(),chsRndm.class);
        intent.putExtra("Message","Technology");
        startActivity(intent);
    }

    public void sprt(View view) {
        Intent intent=new Intent(getApplicationContext(),chsRndm.class);
        intent.putExtra("Message","Sports");
        startActivity(intent);
    }

    public void caf(View view) {
        Intent intent=new Intent(getApplicationContext(),chsRndm.class);
        intent.putExtra("Message","CurrentAffairs");
        startActivity(intent);
    }
}
