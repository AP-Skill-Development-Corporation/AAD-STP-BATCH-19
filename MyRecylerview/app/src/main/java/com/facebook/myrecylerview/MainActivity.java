package com.facebook.myrecylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rec;
    String title[];
    int images[];
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec= findViewById(R.id.recycler);
        images = new int[]{R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,R.mipmap.ic_launcher};
        title = getResources().getStringArray(R.array.upendra);
        adapter=new MyAdapter(this,title,images);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(adapter);

    }
}