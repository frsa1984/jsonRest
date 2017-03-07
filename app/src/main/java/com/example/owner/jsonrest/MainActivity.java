package com.example.owner.jsonrest;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Handler handler;
    TextView TV;
    EditText ET;
    EditText ET2;
    EditText ET3;
    String numberHolder;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TV = (TextView) findViewById(R.id.textView);
        ET = (EditText) findViewById(R.id.editText);
        ET2 = (EditText) findViewById(R.id.editText2);
        ET3 = (EditText) findViewById(R.id.editText3);


//        handler = new Handler();

 /*       hidService hid = new hidService();
        String valueHolder;
        valueHolder = hid.getValueHolder();
        ET3.setText(valueHolder);
*/

        hidService2 hid = new hidService2();
        String valueHolder;
        valueHolder = hid.getValueHolder();
        ET3.setText(valueHolder);


      /*Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateData();
                                updateData();
                                //updateData2();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();*/




    }

    private void updateData(){

        new Thread(){
            public void run(){
                final String value = RemoteFetch.getJSON(getBaseContext());
                if(value == null  ){
                                    handler.post(new Runnable(){
                                         public void run(){
                                             TV.setText("value variable is empty");
                                         }
                    });
                } else {
                    handler.post(new Runnable(){
                        public void run(){
                            if (value .equals(""))   { numberHolder = "" ; }
                            if (value .equals("30 ")){ numberHolder = "1"; }
                            if (value .equals("31 ")){ numberHolder = "2"; }
                            if (value .equals("32 ")){ numberHolder = "3"; }
                            if (value .equals("33 ")){ numberHolder = "4"; }
                            if (value .equals("34 ")){ numberHolder = "5"; }
                            if (value .equals("35 ")){ numberHolder = "6"; }
                            if (value .equals("36 ")){ numberHolder = "7"; }
                            if (value .equals("37 ")){ numberHolder = "8"; }
                            if (value .equals("38 ")){ numberHolder = "9"; }
                            if (value .equals("39 ")){ numberHolder = "0"; }
                            ET.setText(ET.getText()+numberHolder);
                            numberHolder ="";
                            ET.setSelection(ET.getText().length());
                        }
                    });
                }
            }
        }.start();
    }

    /*private void updateData2(){

        new Thread(){
            public void run(){
                final String value = RemoteFetch2.getJSON(getBaseContext());
                if(value == null  ){
                    handler.post(new Runnable(){
                        public void run(){
                            TV.setText("value variable is empty");
                        }
                    });
                } else {
                    handler.post(new Runnable(){
                        public void run(){
                            if(value != ""){
                            ET2.setText(value);
                            ET2.setSelection(ET2.getText().length());
                            }
                        }
                    });
                }
            }
        }.start();
    }*/

    public void clickButton(View V){
        updateData();
        updateData();
    }

    /*public void clickButton2(View V){
        updateData2();
    }*/

 /*   public void startService(View view){
        Intent intent = new Intent(this,hidService.class);
        startService(intent);
    }
    public void stopService(View view){
        Intent intent = new Intent(this,hidService.class);
        stopService(intent);
    }*/
    public void startService(View view){
        Intent intent = new Intent(this,hidService2.class);
        startService(intent);
    }
    public void stopService(View view){
        Intent intent = new Intent(this,hidService2.class);
        stopService(intent);
    }




}
