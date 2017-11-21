package com.idit.elm327;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import de.greenrobot.event.EventBus;

public class DeviceBroadcastReceiver extends BroadcastReceiver
{
    private static final String TAG = "DeviceBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String action = intent.getAction();
        if (BluetoothDevice.ACTION_FOUND.equals(action))
        {
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            EventBus.getDefault().post(device);
            displayLog("Dispositivo encontrado: " + device.getName() + " (" + device.getAddress() + ")");
        }
    }

    private void displayLog(String msg)
    {
        Log.d(TAG, msg);
    }
}
