package com.facebook.intents_b19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        t1 = findViewById(R.id.text1);
        Bundle bundle = getIntent().getExtras();
        String data =bundle.getString("KEY");
        t1.setText(""+data);
    }
}