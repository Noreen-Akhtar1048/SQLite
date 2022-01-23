package com.myfirstapp.sqlite_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    dbms mydbms;
    TextInputEditText Name,Designation,Salary,Bonus,Age;
    Button add_data,see_info;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydbms = new dbms(this);
        Name = (TextInputEditText)findViewById(R.id.Enter_name);
        Age = (TextInputEditText)findViewById(R.id.Enter_Age);
        Salary = (TextInputEditText)findViewById(R.id.Enter_Salary);
        Designation = (TextInputEditText)findViewById(R.id.Enter_designation);
        Bonus = (TextInputEditText)findViewById(R.id.Enter_Bonus);
        floatingActionButton = findViewById(R.id.floatingactionbutton);

        add_data = findViewById(R.id.button_save);

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               processInsert(Name.getEditableText().toString(),Age.getEditableText().toString(),
                       Salary.getEditableText().toString(),Designation.getEditableText().toString(),
                       Bonus.getEditableText().toString());
            }

        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Add_data.class));
            }
        });

    }

    private void processInsert(String n, String a, String s, String d, String b) {
        String res = new dbms(this).insert_Data(n,a,s,d,b);
        Name.setText(" ");
        Age.setText(" ");
        Salary.setText(" ");
        Designation.setText(" ");
        Bonus.setText(" ");
        Toast.makeText(MainActivity.this,res, Toast.LENGTH_SHORT).show();

    }
}