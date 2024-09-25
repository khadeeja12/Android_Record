package com.example.systemintent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        if (Settings.System.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0)==0){
            Toast.makeText(context,"airplane mode OFF",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context,"airplane mode ON",Toast.LENGTH_SHORT).show();
        }
    }
}