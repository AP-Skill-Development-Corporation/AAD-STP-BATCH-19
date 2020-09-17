package com.facebook.countapp_b19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.text1);
    }

    public void mCount(View view) {
        n++;
        t1.setText(""+n);
    }

    public void mToast(View view) {
        /*Toast is a display message that popup for a specific duration.*/
        Toast.makeText(this,"Hai Friends",Toast.LENGTH_LONG).show();
    }
}