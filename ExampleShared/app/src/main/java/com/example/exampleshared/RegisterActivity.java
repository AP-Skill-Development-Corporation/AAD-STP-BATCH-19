package com.example.exampleshared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    SharedPreferences sp;
    EditText uname,upass,umail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        uname = findViewById(R.id.uname);
        upass = findViewById(R.id.upass);
        umail = findViewById(R.id.umail);
        sp = getSharedPreferences("MyDatabase",MODE_PRIVATE);
    }

    public void register(View view) {
        String name = uname.getText().toString();
        String pass = upass.getText().toString();
        String mail = umail.getText().toString();
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("un",name);
        editor.putString("up",pass);
        editor.putString("um",mail);
        editor.commit();
        Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show();
    }
}