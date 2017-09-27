package com.example.android.thermostat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Log.d("myTag", "We are in Settings Java code!");
    }

    // android:onClick="buttonHandler" in XML design file
    public void buttonHandler(View v) {

        int i = v.getId();
        if (i == R.id.button_h1) {
            Log.d("myTag", "Settings button in Home screen was clicked!");
            Intent intent = new Intent(this,Settings.class);
            startActivity(intent);

        }
        //other buttons for this Activity go here
        else if (i == R.id.button_s1) {
            Log.d("myTag", "Home button in Settings screen was clicked!");
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        }
    }
}