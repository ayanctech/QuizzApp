package com.example.android.quizzproject;

/**
 * Created by JidanPC on 8/9/2017.
 */

public class questions {
    private String Question="";
    private String Option_A ="";
    private String Option_B ="";
    private String Option_C ="";
    private String Option_D ="";
    private String Answer ="";

    questions(String mQuestion,String mOptionA,String mOptionB,String mOptionC,String mOptionD,String mAnswer){

        Question=mQuestion;
        Option_A=mOptionA;
        Option_B=mOptionB;
        Option_C=mOptionC;
        Option_D=mOptionD;
        Answer=mAnswer;
    }
    public String getQuestion(){return Question;}
    public String getOption_A(){return Option_A;}
    public String getOption_B(){return Option_B;}
    public String getOption_C(){return Option_C;}
    public String getOption_D(){return Option_D;}
    public String getAnswer(){return Answer;}
}
