package com.myfirstapp.sqlite_app;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Add_data extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<model> dataholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor = new dbms(this).read_data();

        while (cursor.moveToNext())
        {
            model obj = new model(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
            dataholder.add(obj);

        }
        my_adapter myAdapter = new my_adapter(dataholder);
        recyclerView.setAdapter(myAdapter);
    }
}