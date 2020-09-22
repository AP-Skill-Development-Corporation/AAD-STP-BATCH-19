package com.facebook.inputcontrollers_b19;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radiob1,radiob2;
    LinearLayout linearLayout;
    Switch aSwitch;
    CheckBox cb1,cb2,cb3;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner1);
        linearLayout = findViewById(R.id.linear1);
        aSwitch = findViewById(R.id.switch1);
        radioGroup = findViewById(R.id.rg1);
        radiob1 = findViewById(R.id.rb1);
        radiob2 = findViewById(R.id.rb2);
        cb1 = findViewById(R.id.chec1);
        cb2 = findViewById(R.id.chec2);
        cb3 = findViewById(R.id.chec3);
        ArrayList<String>  weeks = new ArrayList<>();
        weeks.add("SunDay");
        weeks.add("MonDay");
        weeks.add("TuesDay");
        weeks.add("WednesDay");
        weeks.add("ThursDay");
        weeks.add("FriDay");
        weeks.add("SaturDay");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,weeks);
        spinner.setAdapter(adapter);

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aSwitch.isChecked()){
                    linearLayout.setBackgroundColor(Color.YELLOW);
                }
                else{
                    linearLayout.setBackgroundColor(Color.GREEN);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb1:
                        Toast.makeText(MainActivity.this, "Male", Toast.LENGTH_SHORT).show();
                     break;
                    case R.id.rb2:
                        Toast.makeText(MainActivity.this, "FeMale", Toast.LENGTH_SHORT).show();
                     break;
                }

            }
        });
    }

    public void touchme(View view) {
        Toast.makeText(this, "You Selected Img", Toast.LENGTH_SHORT).show();
}

    public void save(View view) {
        if (cb1.isChecked()&&cb2.isChecked()&&cb3.isChecked()){
            Toast.makeText(this, ""+cb1.getText()+","+cb2.getText()+","+
                    cb3.getText(), Toast.LENGTH_SHORT).show();
        }else if(cb1.isChecked()&&cb2.isChecked()){
            Toast.makeText(this, ""+cb1.getText()+","+cb2.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(cb2.isChecked()&&cb3.isChecked()){
            Toast.makeText(this, ""+cb2.getText()+","+cb3.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(cb1.isChecked()&&cb3.isChecked()){
            Toast.makeText(this, ""+cb1.getText()+","+cb3.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(cb1.isChecked()){
            Toast.makeText(this, ""+cb1.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(cb2.isChecked()){
            Toast.makeText(this, ""+cb2.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(cb3.isChecked()){
            Toast.makeText(this, ""+cb3.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}