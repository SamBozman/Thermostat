package com.example.android.thermostat;

import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by SamB64 on 10/7/2017.
 */

public class CountDownRunner extends MainActivity implements Runnable {
    // @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                doWork();
                Thread.sleep(1000); // Pause of 1 Second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }catch(Exception e){
            }
        }
    }

    public void doWork() {
        runOnUiThread(new Runnable() {
            public void run() {
                try{
                    TextView txtCurrentTime= (TextView)findViewById(R.id.dateText);
                    Calendar calendar = Calendar.getInstance();
                    DateFormat df = new SimpleDateFormat("EEE, MMM d yyyy HH:mm:ss");
                    Date d = calendar.getTime();
                    String calendarStr = df.format(calendar.getTime());
                    txtCurrentTime.setText(calendarStr);
                }catch (Exception e) {}
            }
        });
    }

}
