package com.actech.jidanpc.quizproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

public class Rndm extends AppCompatActivity {
    String[] qsnarrray;
    URL qurl;
    String code;
    int i=1;
    String catgMsg="";
    int nos;
    String correct_ans;
    int tot_score=0;

    String op11,op12,op13;

    TextView tv1,tv2,tv3,tv4,tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rndm);

        Intent intent=getIntent();
        nos=intent.getIntExtra("no_of_qsns",10);
        catgMsg=intent.getStringExtra("Msg");

        RelativeLayout relativeLayout=findViewById(R.id.main_layout);

        switch(catgMsg){
            case "Rndm":
                code="9";
                //relativeLayout.setBackgroundResource(R.drawable.random);
                Toast.makeText(getApplicationContext(),"Rndm selected ",Toast.LENGTH_SHORT).show();
                break;
            case "Technology":
                code="18";
                Toast.makeText(getApplicationContext(),"technology selected ",Toast.LENGTH_SHORT).show();
                break;
            case "Sports":
                code="21";
                //relativeLayout.setBackgroundResource(R.drawable.sports);
                break;
            case "Music":
                code="12";
                Toast.makeText(getApplicationContext(),"mythology selected ",Toast.LENGTH_SHORT).show();
                break;
            case "History":
                code="23";
                Toast.makeText(getApplicationContext(),"history selected ",Toast.LENGTH_SHORT).show();
                break;
            case "Entertainments":
                code="11";
                break;
            case "Science and Nature":
                code="17";
                break;
            case "Animal":
                code="27";
                break;
            default:
                code="9";
                break;
        }


        tv1=(TextView)findViewById(R.id.textview_question);
        tv2=(TextView)findViewById(R.id.radiobutton_1);
        tv3=(TextView)findViewById(R.id.radiobutton_2);
        tv4=(TextView)findViewById(R.id.radiobutton_3);
       tv5=(TextView)findViewById(R.id.radiobutton_4);


        qurl= netjson.buildWURL(code);
        new FetchQsnResponse().execute(qurl);

    }

    private class FetchQsnResponse extends AsyncTask<URL,Void,String> {
        int i=0;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL qsnrurl=urls[0];
            String qsnsrchresult=null;

            try {
                qsnsrchresult= netjson.getResponseFromHttpUrl(qsnrurl);
            } catch (IOException e) {
                e.printStackTrace();
            }


            return qsnsrchresult;
        }

        @Override
        protected void onPostExecute(String s) {
            if(s!=null && !s.equals("")){
                parseJson(s);
            }
            super.onPostExecute(s);
        }
    }






    private String[] parseJson(String s) {
        if(qsnarrray!=null)
            qsnarrray=null;
        if(s!=null){
            try {
                JSONObject jobj=new JSONObject(s);
                JSONArray jarr=jobj.getJSONArray("results");

                if(jarr==null)
                    Log.i("Sports","Connectivity failed");

                questions qsn=new questions();

                JSONObject res=jarr.getJSONObject(i);

                String qstn=res.getString("question");
                qsn.setQuestion(qstn);

                correct_ans=res.getString("correct_answer");
                qsn.setAnswer(correct_ans);

                JSONArray tmpObj=res.getJSONArray("incorrect_answers");
                op11=tmpObj.get(0).toString();
                op12=tmpObj.get(1).toString();
                op13=tmpObj.get(2).toString();

                qsn.setOption_A(correct_ans);
                qsn.setOption_B(op11);
                qsn.setOption_C(op12);
                qsn.setOption_D(op13);


                tv1.setText(qstn);

                setOptions();


                return qsnarrray;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void setOptions() {
        Random rnd=new Random();
       int index=rnd.nextInt(3);
       switch (index){
           case 0:
               tv2.setText(correct_ans);
               tv3.setText(op11);
               tv5.setText(op12);
               tv4.setText(op13);
               break;
           case 1:
               tv3.setText(correct_ans);
               tv2.setText(op11);
               tv4.setText(op12);
               tv5.setText(op13);
               break;
           case 2:
               tv4.setText(correct_ans);
               tv2.setText(op11);
               tv3.setText(op12);
               tv5.setText(op13);
               break;
           case 3:
               tv5.setText(correct_ans);
               tv2.setText(op11);
               tv3.setText(op12);
               tv4.setText(op13);
               break;
       }


    }

    public void prev(View view){
        // String code="21";
        // URL qurl= netjson.buildWURL(code);
        if(i>0) {
            i--;
            new FetchQsnResponse().execute(qurl);

        }
        else {
            Toast.makeText(getApplicationContext(),"Nowhere to go ",Toast.LENGTH_SHORT).show();
        }
    }


    public void next(View view){
        if(i<nos) {
            i++;
            new FetchQsnResponse().execute(qurl);

        }
        else {
            Toast.makeText(getApplicationContext(),"Nowhere to go ",Toast.LENGTH_SHORT).show();
        }
    }

    public void Submit(View view) {

        RadioGroup radioGroup=(RadioGroup) findViewById(R.id.radgrp);
        int ridg=radioGroup.getCheckedRadioButtonId();
        RadioButton rad=(RadioButton) findViewById(ridg);
        if(rad!=null){
            String ans=rad.getText().toString();

            if(ans==correct_ans) {
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
        if(i<nos) {
            i += 1;
            radioGroup.clearCheck();
            new FetchQsnResponse().execute(qurl);
        }
        else if(i==nos){
                Intent intent = new Intent(getApplicationContext(), score.class);
                intent.putExtra("score", tot_score);
                intent.putExtra("RootClassMsg", "Rndm");
                startActivity(intent);
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
