package com.example.android.thermostat;
//TestGit
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//TODO Have MainActivity run automatically if app crashes or stops for any reason

    TextView cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, weatherIcon, updatedField;
    Typeface weatherFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        weatherFont = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/weathericons-regular-webfont.ttf");

        cityField = (TextView)findViewById(R.id.city_field);
        updatedField = (TextView)findViewById(R.id.updated_field);
        detailsField = (TextView)findViewById(R.id.details_field);
        currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
        humidity_field = (TextView)findViewById(R.id.humidity_field);
        pressure_field = (TextView)findViewById(R.id.pressure_field);
        weatherIcon = (TextView)findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);

        Function.AsyncResponse asyncResponse = new Function.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {
                weather_description = weather_description.substring(0, 1).toUpperCase() + weather_description.substring(1).toLowerCase();
                cityField.setText(weather_city);
                updatedField.setText(weather_updatedOn);
                detailsField.setText(weather_description);
                currentTemperatureField.setText(weather_temperature);
                humidity_field.setText("Humidity: "+weather_humidity);
                pressure_field.setText("Pressure: "+weather_pressure);
                weatherIcon.setText(Html.fromHtml(weather_iconText));

            }
        };

        Function.placeIdTask asyncTask = new Function.placeIdTask(asyncResponse);
        //TODO Remove comment on line below in order that weather can run
        //asyncTask.execute("49.104431", "-122.801094"); // ("Latitude", "Longitude")
        //TODO Have asyncTask run at least once a day.


        //Thread used to update time and date
        Thread myThread = null;
        Runnable myRunnableThread = new CountDownRunner();
        myThread= new Thread(myRunnableThread);
        myThread.start();

    }


    public  void buttonHandler(View v) {
        //File myDir = getFilesDir();
        int i = v.getId();
        if (i == R.id.but_home_set) {
            Log.d("myTag", "SettingsActivity button in Home screen was clicked!");
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
            Log.d("myTag", "We are in Settings screen");
            //RW_Object.writeConfig(myDir);
        }

        else if (i == R.id.but_set_home) {
            Log.d("myTag", "Home button in SettingsActivity screen was clicked!");
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            Log.d("myTag", "We are in the Home screen");
            //RW_Object.readConfig(myDir);
        }

        else if (i == R.id.but_sched_home) {
            Log.d("myTag", "Home button in SchedulesActivity screen was clicked!");
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            Log.d("myTag", "We are in Home screen!");
            //RW_Object.readConfig(myDir);
        }

        else if (i == R.id.but_set_sched) {
            Log.d("myTag", "Schedules button in SettingsActivity screen was clicked!");
            Intent intent = new Intent(this,ScheduleActivity.class);
            startActivity(intent);
            Log.d("myTag", "We are in Schedules screen");
            //RW_Object.readConfig(myDir);
        }

    }

}
