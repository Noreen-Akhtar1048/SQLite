package com.myfirstapp.sqlite_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbms extends SQLiteOpenHelper {
    public static final String dbms_name = "Employee_info";

    public dbms(@Nullable Context context) {
        super(context, dbms_name, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry = ("Create table Employee_info (EMPLOYEE_ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,AGE INTEGER,SALARY INTEGER,DESIGNATION TEXT,BONUS TEXT)");
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String qry = ("DROP TABLE IF EXISTS Employee_info");
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }
    public String insert_Data(String name, String age, String salary, String designation, String bonus)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("AGE",age);
        contentValues.put("SALARY",salary);
        contentValues.put("DESIGNATION",designation);
        contentValues.put("BONUS",bonus);
        float result = sqLiteDatabase.insert("Employee_info",null,contentValues);
        if(result == -1)
            return "failed";
        else
            return "successfully inserted";
    }
    public Cursor read_data(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "select * from Employee_info order by EMPLOYEE_ID desc";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor;
    }
}
