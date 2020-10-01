package com.example.exampleshared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView tv;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv = findViewById(R.id.tv);
        sp = getSharedPreferences("MyDatabase",MODE_PRIVATE);
        tv.setText("Welcome "+sp.getString("um",null));
    }
}