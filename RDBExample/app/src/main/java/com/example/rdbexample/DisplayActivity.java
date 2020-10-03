package com.example.rdbexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import com.example.rdbexample.Rdb.RDatabase;
import com.example.rdbexample.Rdb.RTable;

import java.util.List;

public class DisplayActivity extends AppCompatActivity {
    RecyclerView rv;
    RDatabase rdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        rv = findViewById(R.id.rv);
        rdb = Room.databaseBuilder(this, RDatabase.class,"MYROOM")
                .allowMainThreadQueries().build();
        List<RTable> list = rdb.rDao().getAll();
        MyAdapter adapter = new MyAdapter(this,list);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}