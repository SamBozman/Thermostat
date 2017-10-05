package com.example.android.thermostat;

/**
 * Created by SamB64 on 9/7/2017.
 */

public class Schedule implements java.io.Serializable {
    boolean enabled;
    int days;
    int hourStart;
    int minuteStart;
    int hourStop;
    int minuteStop;
    float temp;  //Holds heater modes for each schedule. Initially set to HEATER_MODE_HI (4)

    Schedule(){
        enabled = false;
        days = 1;
        hourStart = 0;
        minuteStart = 0;
        hourStop = 0;
        minuteStop = 0;
        temp = 18.5f;

    }
    }
