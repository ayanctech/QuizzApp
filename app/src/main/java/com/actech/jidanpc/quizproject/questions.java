package com.actech.jidanpc.quizproject;

/**
 * Created by JidanPC on 7/19/2017.
 */

public class questions {
    private String Question="";
    private String Option_A ="";
    private String Option_B ="";
    private String Option_C ="";
    private String Option_D ="";
    private String Answer ="";

    public questions(){}

    public questions(String mQuestion,String mOptionA,String mOptionB,String mOptionC,String mOptionD,String mAnswer){

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

    public void setQuestion(String question) {
        Question = question;
    }

    public void setOption_A(String option_A) {
        Option_A = option_A;
    }

    public void setOption_B(String option_B) {
        Option_B = option_B;
    }

    public void setOption_C(String option_C) {
        Option_C = option_C;
    }

    public void setOption_D(String option_D) {
        Option_D = option_D;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}