package com.actech.jidanpc.quizproject;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by ACTECH on 12/18/2017.
 */

public class netjson {
    int c=1;
    private static String qsnRef="https://opentdb.com/api.php?amount=20&category=";
    private static String chRef="&difficulty=medium&type=multiple";
    public static URL buildWURL(String key){
        qsnRef=qsnRef+key+chRef;
        Uri qsnuri=Uri.parse(qsnRef).buildUpon().build();

        URL url=null;

        qsnRef="https://opentdb.com/api.php?amount=20&category=";
        try {
            url=new URL(qsnuri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url ) throws IOException{
        HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();

        try {
            InputStream inp=httpURLConnection.getInputStream();
            Scanner scn=new Scanner(inp);
            scn.useDelimiter("\\A");

            boolean hasImput=scn.hasNext();
            if(hasImput){
                return scn.next();
            }
            else
                return null;
        }
        finally {
            httpURLConnection.disconnect();
        }
    }
}
