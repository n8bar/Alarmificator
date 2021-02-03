package com.natetheprogrammer.alarmificator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    
    private void scheduleAlarm(View view) {
        Context context=view.getContext();
        int alarmId=0;
        
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        //Intent intent = new Intent(context, AlarmBroadcastReceiver.class);
        //intent.putExtra("Title", "Alarm Title");
        //intent.putExtra("Message", "Yo!");

        //PendingIntent pi = PendingIntent.getBroadcast(context, alarmId, intent, 0 );
        
        //alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
    }
}