package com.example.exampleshared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,pass;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        sp = getSharedPreferences("MyDatabase",MODE_PRIVATE);
    }

    public void login(View view) {
        String uname = name.getText().toString();
        String upass = pass.getText().toString();
        String n = sp.getString("un",null);
        String p = sp.getString("up",null);
        if (uname.isEmpty()||upass.isEmpty()){
            Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show();
        }else if(uname.equals(n)&&upass.equals(p)){
            startActivity(new Intent(this,HomeActivity.class));
            Toast.makeText(this, "Authentication Successful", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void register(View view) {
        startActivity(new Intent(this,RegisterActivity.class));
    }
}