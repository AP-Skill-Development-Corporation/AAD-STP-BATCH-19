package com.example.examplework;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ThirdWork extends Worker {
    NotificationManager nm;
    public ThirdWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @NonNull
    @Override
    public Result doWork() {
        createNotification();
        sendNotification();
        Log.i("Apssdc","This is third work");
        return Result.success();
    }

    private void sendNotification() {
        NotificationCompat.Builder builder=new NotificationCompat
                .Builder(getApplicationContext(),"Apssdc");
        builder.setContentTitle("Notification");
        builder.setContentText("This is my notification");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        nm.notify(0,builder.build());
    }

    private void createNotification() {
        //In this method we write notification for the android version 8 and above
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel nc = new NotificationChannel("Apssdc","Notify",
                    NotificationManager.IMPORTANCE_HIGH);
            nc.enableVibration(true);
            nc.enableLights(true);
            nc.setLightColor(Color.GREEN);
            nm.createNotificationChannel(nc);
        }
    }
}
