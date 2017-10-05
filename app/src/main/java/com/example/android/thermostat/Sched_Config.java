package com.example.android.thermostat;

/**
 * Created by SamB64 on 9/7/2017.
 */

public class Sched_Config implements java.io.Serializable {
    long  config_revision;
    int heaterMode; //Initally set to HEATER_MODE_OFF
    float temp_lolo; //Each of these temperatures can be set in Temperature Screen
    float temp_lo;   // Initially set to 19.0, 20.0, 21.0 and 22.0
    float temp_hi;
    float temp_hihi;
    float temp_manual; //Holds the temp setting for Manual Mode on Main Screen (Initally set to 20.0C)

    Schedule[] schedules = new Schedule[10];

//Constructor
    Sched_Config(){
        for (int i = 0; i < 10; i++) {
            schedules[i]= new Schedule();
        }

        heaterMode = 0;
        temp_lolo = 18.0f;
        temp_lo   = 20.0f;
        temp_hi   = 21.0f;
        temp_hihi = 22.0f;
        temp_manual = 20.0f;

    }

}
