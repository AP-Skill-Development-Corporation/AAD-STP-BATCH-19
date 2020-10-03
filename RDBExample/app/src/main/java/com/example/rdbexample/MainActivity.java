package com.example.rdbexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rdbexample.Rdb.RDatabase;
import com.example.rdbexample.Rdb.RTable;

public class MainActivity extends AppCompatActivity {
    EditText name,roll,number;
    RDatabase rdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.sname);
        roll = findViewById(R.id.sroll);
        number = findViewById(R.id.sphone);
        rdb = Room.databaseBuilder(this,RDatabase.class,"MYROOM")
                .allowMainThreadQueries().build();
    }

    public void save(View view) {
        RTable rTable = new RTable();
        rTable.setName(name.getText().toString());
        rTable.setRoll(roll.getText().toString());
        rTable.setNumber(number.getText().toString());
        rdb.rDao().insert(rTable);
        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,DisplayActivity.class));
    }
}