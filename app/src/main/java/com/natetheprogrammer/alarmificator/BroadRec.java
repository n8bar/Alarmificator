package com.natetheprogrammer.alarmificator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadRec extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        
        String title = intent.getStringExtra("Title");
        String msg = intent.getStringExtra("Message");
        
        String toastText = String.format( title + "\n" + msg );
        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        
    }

    private void startAlarmService(Context context, Intent intent) {
        
    }

    private void reschedAlarmService() {
    }
    
}
