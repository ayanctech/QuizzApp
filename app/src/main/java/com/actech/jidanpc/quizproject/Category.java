package com.actech.jidanpc.quizproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class Category extends AppCompatActivity {
    private FeatureCoverFlow coverFlow;
    private CoverFlowAdapter adapter;
    private ArrayList<QuizTopic> quizTopics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);

        settingDummyData();
        adapter = new CoverFlowAdapter(this, quizTopics);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());
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
        intent.putExtra("Message","Music");
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sign_out_menu:
                AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(getApplicationContext(), "Successfully Logged out ", Toast.LENGTH_SHORT).show();
                            }
                        });
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void hist(View view) {
        Intent intent=new Intent(getApplicationContext(),chsRndm.class);
        intent.putExtra("Message","History");
        startActivity(intent);
    }
    public void entm(View view) {
        Intent intent=new Intent(getApplicationContext(),chsRndm.class);
        intent.putExtra("Message","Entertaiment");
        startActivity(intent);
    }public void pols(View view) {
        Intent intent=new Intent(getApplicationContext(),chsRndm.class);
        intent.putExtra("Message","Science and Nature");
        startActivity(intent);
    }public void art(View view) {
        Intent intent=new Intent(getApplicationContext(),chsRndm.class);
        intent.putExtra("Message","Animal");
        startActivity(intent);
    }

    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("Category", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("Category", "scrolling");
            }
        };
    }

    private void settingDummyData() {
        quizTopics = new ArrayList<>();
        quizTopics.add(new QuizTopic(R.drawable.rndm2, "Random"));
        quizTopics.add(new QuizTopic(R.drawable.tech, "Technology"));
        quizTopics.add(new QuizTopic(R.drawable.sports, "Sports"));
        quizTopics.add(new QuizTopic(R.drawable.music, "Music"));
        quizTopics.add(new QuizTopic(R.drawable.hist, "History"));
        quizTopics.add(new QuizTopic(R.drawable.entm, "Entertainments"));
        quizTopics.add(new QuizTopic(R.drawable.science, "Science & Nature"));
        quizTopics.add(new QuizTopic(R.drawable.animals2, "Animals"));
    }
}
