package com.example.android.quizzproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by JidanPC on 8/10/2017.
 */

public class SetQuestions {


    public static void setQsns(TextView textView_question, RadioButton radioButton1, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, String catgMsg, Context context, ArrayList<questions> questionsArrayList, int nos, int count, int i, int tot_score) {



            questionsArrayList.add(new questions("When did the Republic of South Sudan gain its independence?", "July 9,2011", "July 1,2011", "July 9,2010", "July 1,2010", "July 9,2011"));
            questionsArrayList.add(new questions("What musical instrument's name means \"bells playing\" in German?", "Glockenspiel", "Ackenspien", "Glocketid", "Ackerin", "Glockenspiel"));
            questionsArrayList.add(new questions("What nationality is a Breton?", "French", "German", "British", "Irish", "French"));
            questionsArrayList.add(new questions("What major river runs through Buenos Aires?", "Rio de la Plata", "Rio se ka Hata", "Rio di fe Wlata", "Aires Plata", "Rio de la Plata"));
            questionsArrayList.add(new questions("In what century did the Dodo bird become extinct?", "17th", "20th", "19th", "18th", "17th"));
            questionsArrayList.add(new questions("What royal subject married Timothy Laurence?", "Princess Anne", "Princess Hnne", "Princess Fina", "Princess Riko", "Princess Anne"));
            questionsArrayList.add(new questions("What is the fear of lice called?", "Pediculophobia", "Snoediculophobia", "Cediculophobia", "Icediculophobia", "Pediculophobia"));
            questionsArrayList.add(new questions("A plague is a group of what insect?", "Locust", "Bugs", "Butterflies", "Moths", "locust"));
            questionsArrayList.add(new questions("When was the maiden voyage of the \"Titanic\"?", "1913", "1912", "1911", "1914", "1912"));
            questionsArrayList.add(new questions("What artist received the most Grammy Awards in 2016?", "Kendrick Lamar", "Ammy Pedro", "Mark Curl", "Sushi Finjurbak", "Kendrick Lamar"));

            questionsArrayList.add(new questions("Where might you drink Retsina wine?", "France", "Rome", "Greece", "Afganistan", "Greece"));


        if(catgMsg=="Technology") {
            questionsArrayList.add(new questions("Who was the co-founder of Microsoft alongside Bill Gates?", "Jimmy Richardson", "Melinda Gates", "Roger Sharma", "Paul Allen", "Paul Allen"));
            questionsArrayList.add(new questions("In 1999 an email Service's Vulnerability was reportedly exposed by a Hacker group saying its' all email accounts can be logged in using a password\"eh\" ?", "Gmail", "Hotmail", "Rediffmail", "Yahoo", "Hotmail"));
            questionsArrayList.add(new questions("Who used the binary system of numeration for the first time?", "Thomas Harriot", "Bellford German Jr.", "Mondhojun Dimpshaw", "Kane Rogers", "Thomas Harriot"));
            questionsArrayList.add(new questions("PhonePE, NGpay and FXmart are the major acquisitions of?", "Amazon", "Flipkart", "Snapdeal", "Myntra", "Flipkart"));
            questionsArrayList.add(new questions("Which American company is known as “Big Blue”?", "Google", "Twitter", "Facebook", "IBM", "IBM"));
            questionsArrayList.add(new questions("Who build the first electromechanical computer?", "Max Luthar", "Fredrick Nicolas", "Konrad Zuse", "Kante Riko", "Konrad Zuse"));
            questionsArrayList.add(new questions("X is a programming language developed by a company Y. Y formed “The Green Project” for developing X. Name X, Y ?", "X – C Y – Bell", "X – Java Y – Sun Microsystems", "X – c# Y – Microsoft", "X – pYTHON Y – CWI", "X – Java Y – Sun Microsystems"));
            questionsArrayList.add(new questions("Who is the first computer programmer?", "Doistry Lovelace", "Ada Seringhum", "Ada Lovelace", "Doistry Seringhum","Doistry Lovelace"));
            questionsArrayList.add(new questions("Who invented Computer Mouse?", "Doughles Engelbert", "Christopher Latham Sholes", "Federico Faggin", "John Ericsson", "Doughles Engelbert"));
            questionsArrayList.add(new questions("What artist received the most Grammy Awards in 2016?", "Kendrick Lamar", "Ammy Pedro", "Mark Curl", "Sushi Finjurbak", "Kendrick Lamar"));

            questionsArrayList.add(new questions("Which one of the email service is founded by an Indian ?", "Hotmail", "Outlook", "Yahoo", "Rediffmail", "Hotmail"));
        }
        else{

            questionsArrayList.add(new questions("This is demoQsn1?", "July 9,2011", "July 1,2011", "July 9,2010", "July 1,2010", "July 9,2011"));
            questionsArrayList.add(new questions("This is demoQsn2?", "Glockenspiel", "Ackenspien", "Glocketid", "Ackerin", "Glockenspiel"));
            questionsArrayList.add(new questions("This is demoQsn3?", "French", "German", "British", "Irish", "French"));
            Toast.makeText(context.getApplicationContext(), catgMsg, Toast.LENGTH_LONG).show();
        }





        if(count<nos) {
            count++;

            String qsn = questionsArrayList.get(i).getQuestion();
            textView_question.setText(qsn);
            radioButton1.setText(questionsArrayList.get(i).getOption_A());
            radioButton2.setText(questionsArrayList.get(i).getOption_B());
            radioButton3.setText(questionsArrayList.get(i).getOption_C());
            radioButton4.setText(questionsArrayList.get(i).getOption_D());
        }
        else{
            Intent intent=new Intent(context.getApplicationContext(),score.class);
            intent.putExtra("score",tot_score);
            intent.putExtra("RootClassMsg","Rndm");
            context.startActivity(intent);
        }
    }
}
