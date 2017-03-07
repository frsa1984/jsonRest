package com.example.owner.jsonrest;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by owner on 3/6/2017.
 */

public class hidService2 extends Service {

    String valueHolder;
    String value;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {




        Toast.makeText(this,"Service started",Toast.LENGTH_SHORT).show();
        synchronized (this){

            int count = 0;
            while (count<10){
                try {
                    wait(1500);
                    count++;

                    final String value = RemoteFetch2.getJSON(getBaseContext());
                    if (value != ("")) {
                        valueHolder = value;
                        setValueHolder(valueHolder);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Service Destroyed",Toast.LENGTH_SHORT).show();
    }

    //@Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public String getValueHolder() {

        return valueHolder;
    }

    public void setValueHolder(String valueHolder) {
        this.valueHolder = valueHolder;
    }
}
