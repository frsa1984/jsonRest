package com.example.owner.jsonrest;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by owner on 3/6/2017.
 */

public class hidService extends IntentService {

    String valueHolder;
    String value;

    public hidService(){
        super("My_Worker_Thread");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,valueHolder,Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"Service Stopped",Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onHandleIntent(Intent workIntent) {
        //Gets data from the incoming Intent

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



        //Do Work here, based on the contents of dataString


    }
    public String getValueHolder() {
        return valueHolder;
    }

    public void setValueHolder(String valueHolder) {
        this.valueHolder = valueHolder;
    }

}
