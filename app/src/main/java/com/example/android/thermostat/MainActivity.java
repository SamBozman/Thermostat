package com.example.android.thermostat;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
//TODO Have MainActivity run automatically if app crashes or stops for any reason

    TextView cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, weatherIcon, updatedField;
    Typeface weatherFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        Thread myThread = null;
        Runnable myRunnableThread = new CountDownRunner();
        myThread= new Thread(myRunnableThread);
        myThread.start();
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

    class CountDownRunner implements Runnable{
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
    }

    // android:onClick="buttonHandler" in XML design file
    public void buttonHandler(View v) {

        int i = v.getId();
        if (i == R.id.button_h1) {
            Log.d("myTag", "Settings button in Home screen was clicked!");
            Intent intent = new Intent(this,Settings.class);
            startActivity(intent);
            Log.d("myTag", "We are in Settings Java code!");

        }
        //other buttons for this Activity go here
        else if (i == R.id.button_s1) {
            Log.d("myTag", "Home button in Settings screen was clicked!");
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            Log.d("myTag", "We are in MainActivity Java code!");

        }
    }

}
