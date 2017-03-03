package com.example.owner.jsonrest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import android.content.Context;

/**
 * Created by owner on 2/28/2017.
 */

public class RemoteFetch2 {

    public static String getJSON(Context context){
        try {
            URL url = new URL("http://127.0.0.1//prox?mode=oneshot");
            HttpURLConnection connection =
                    (HttpURLConnection)url.openConnection();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp="";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());
            String data2 =(String)data.getString("readValue");

            return data2;
        }catch(Exception e){
            return "";
        }
    }
}
