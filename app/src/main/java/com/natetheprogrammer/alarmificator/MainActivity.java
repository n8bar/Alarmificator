package com.natetheprogrammer.alarmificator;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
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
    EditText etTitle;
    EditText etMsg;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = (EditText) findViewById(R.id.etTitle);
        etMsg = (EditText) findViewById(R.id.etMsg);
        btnScheduleAlarm = (Button) findViewById(R.id.btnScheduleAlarm);
        /*
        btnScheduleAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scheduleAlarm(v);
            }
        });
        /**/
    }
    
    public void scheduleAlarm(View view) {

        Context context=view.getContext();
        
        int alarmId=0;
        
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, BroadRec.class);
        intent.putExtra("Title", etTitle.getText());
        intent.putExtra("Message", etMsg.getText());

        PendingIntent pi = PendingIntent.getBroadcast(context, alarmId, intent, 0 );

        TimePicker timePicker = findViewById(R.id.timePicker);
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
        cal.set(Calendar.MINUTE, timePicker.getMinute());

        assert alarmManager != null;
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
        
        Toast.makeText(view.getContext(), "skejoold", Toast.LENGTH_SHORT).show();
    }
    
}