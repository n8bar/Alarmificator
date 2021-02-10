package com.natetheprogrammer.alarmificator;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class BroadRec extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Toast.makeText(context, "swearwords!", Toast.LENGTH_LONG).show();
        }
        else {
            String title = intent.getStringExtra("Title").toString();
            String msg = intent.getStringExtra("Message").toString();
            context = context.getApplicationContext();
            /**/
            Notification notification = new NotificationCompat.Builder( context, App.CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_baseline_alarm_24)
                    .setContentTitle(title)
                    .setContentText(msg)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .build();

            NotificationManagerCompat nmc = NotificationManagerCompat.from(context);
            nmc.notify(1, notification);
            /**/
            
            String toastText = (title + "\n" + msg);
            Toast.makeText(context, toastText, Toast.LENGTH_LONG).show();

        }
    }

    
}
