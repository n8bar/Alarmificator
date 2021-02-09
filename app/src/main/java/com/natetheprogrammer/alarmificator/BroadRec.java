package com.natetheprogrammer.alarmificator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadRec extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Toast.makeText(context, "swearwords!", Toast.LENGTH_LONG).show();
        }
        else {
            String title = intent.getStringExtra("Title");
            String msg = intent.getStringExtra("Message");

            String toastText = (title + "\n" + msg);
            Toast.makeText(context, toastText, Toast.LENGTH_LONG).show();
        }
    }

    
}
