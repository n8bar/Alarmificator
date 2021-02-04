package com.natetheprogrammer.alarmificator;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TimePicker;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnScheduleAlarm;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /*
        btnScheduleAlarm = (Button) findViewById(R.id.btnScheduleAlarm);
        btnScheduleAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scheduleAlarm(v);
            }
        });
        /**/
    }
    
    public void scheduleAlarm(View view) {

        String toastText = String.format( "Clurked!" );
        Toast.makeText(view.getContext(), toastText, Toast.LENGTH_SHORT).show();
        Context context=view.getContext();
        
        int alarmId=0;
        
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, BroadRec.class);
        intent.putExtra("Title", "Alarm Title");
        intent.putExtra("Message", "Yo!");

        PendingIntent pi = PendingIntent.getBroadcast(context, alarmId, intent, 0 );

        TimePicker timePicker = findViewById(R.id.timePicker);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
        cal.set(Calendar.MINUTE, timePicker.getMinute());
        
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
    }
    
}