package com.actech.jidanpc.quizproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.actech.jidanpc.quizproject.Contract.TblInfo;


import java.security.PrivateKey;

public class DbHelper extends SQLiteOpenHelper{

    Context context;
    String create_Query="CREATE TABLE "+TblInfo.TBL_Name+"("+TblInfo.Col_1+" varchar(30),"+TblInfo.Col_2+" varchar(30),"+TblInfo.Col_3+" varchar(30),"+TblInfo.Col_4+" varchar(30),"+TblInfo.Col_5+" varchar(30),"+TblInfo.Col_6+" varchar(30),"+TblInfo.Col_7+" varchar(30));";
    public DbHelper(Context context) {
        super(context,TblInfo.DB_Name,null,1);
        this.context=context;
        //SQLiteDatabase Mdb=this.getWritableDatabase();
        // Log.d("DatabaseOperations","Database Created Successfuly");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_Query);
        Toast.makeText(context,"Table Created",Toast.LENGTH_LONG).show();
        //Log.d("DatabaseOperations","Table Created Successfuly");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //db.execSQL("DROP TABLE IF EXISTS contacts");
        //onCreate(db);
    }

    public long insertData(String name, String password, String email, String gender, String dob, String s){
        SQLiteDatabase mdb=getWritableDatabase();

        ContentValues cVal=new ContentValues();

        cVal.put(TblInfo.Col_1,name);
        cVal.put(TblInfo.Col_2,password);
        cVal.put(TblInfo.Col_3,email);
        cVal.put(TblInfo.Col_4,gender);
        cVal.put(TblInfo.Col_5,dob);
        cVal.put(TblInfo.Col_6,s);

        return mdb.insert(TblInfo.TBL_Name,null,cVal);
    }

    public Cursor LOGIN(String email, String pass){
        SQLiteDatabase mdb=getWritableDatabase();
        String[] cols={TblInfo.Col_1,TblInfo.Col_2,TblInfo.Col_3,TblInfo.Col_4,TblInfo.Col_5,TblInfo.Col_6};
        String sel=TblInfo.Col_3+"=? and "+TblInfo.Col_2+"=?";
        String[] selection={email,pass};

        return mdb.query(TblInfo.TBL_Name,cols,sel,selection,null,null,null);

    }
}
