package com.actech.jidanpc.quizproject;

/**
 * Created by ayanc on 2/21/2018.
 */

public class QuizTopic {
    private String name;
    private int imageSource;

    public QuizTopic(int imageSource, String name) {
        this.name = name;
        this.imageSource = imageSource;
    }

    public String getName() {
        return name;
    }

    public int getImageSource() {
        return imageSource;
    }
}