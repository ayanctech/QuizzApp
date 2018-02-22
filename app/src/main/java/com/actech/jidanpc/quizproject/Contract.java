package com.actech.jidanpc.quizproject;

import android.provider.BaseColumns;

/**
 * Created by JidanPC on 7/20/2017.
 */

public class Contract {
    public Contract(){}
    public static abstract class TblInfo implements BaseColumns {
        public static final String DB_Name="Stdbs.db";
        public static final String TBL_Name="newTbl";
        public static final String Col_1="ID";
        public static final String Col_2="NAME";
        public static final String Col_3="PASSWORD";
        public static final String Col_4="EMAIL";
        public static final String Col_5="GENDER";
        public static final String Col_6="DOB";
        public static final String Col_7="CITY";

    }
}
