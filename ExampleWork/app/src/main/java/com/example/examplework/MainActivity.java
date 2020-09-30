package com.example.examplework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    OneTimeWorkRequest firstrequest,secondrequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //firstrequest = new OneTimeWorkRequest.Builder(FirstWork.class).build();

        /*Initiating the work with some intial delay*/
        //firstrequest = new OneTimeWorkRequest.Builder(FirstWork.class).setInitialDelay(3, TimeUnit.SECONDS).build();

        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
        firstrequest = new OneTimeWorkRequest.Builder(FirstWork.class)
                .setConstraints(constraints)
                .build();
        secondrequest = new OneTimeWorkRequest.Builder(SecondWork.class).build();
    }

    public void dowork(View view) {
        /*To chain the work in the workmanager*/
        //WorkManager.getInstance(this).beginWith(firstrequest).then(secondrequest).enqueue();

        WorkManager.getInstance(this).enqueue(firstrequest);
       WorkManager.getInstance(this).enqueue(secondrequest);
    }
}