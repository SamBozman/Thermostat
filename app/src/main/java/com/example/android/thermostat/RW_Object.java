package com.example.android.thermostat;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;


//TODO (See below)
/**
 * File myDir = getFilesDir(); Must be used in a method in MainActivity
 * Calls to Write/Read Object are: RW_Object.writeConfig(myDir); AND RW_Object.readConfig(myDir);
 * See buttonHandler for example code (commented out)
 */

public class RW_Object {

    public static void writeConfig(File myDir) {
        String filename = "myObject";
        //File myDir = getFilesDir();
        Sched_Config schedules = new Sched_Config();

        // save the object to file
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            File secondFile = new File(myDir + "/objects/", filename);

            if (secondFile.getParentFile().mkdirs()) { //If file does not exist then...
                secondFile.createNewFile();
                fos = new FileOutputStream(secondFile);
                out = new ObjectOutputStream(fos);
                out.writeObject(schedules);
                out.close();
                Log.i("myLog", "File Saved");
            } else {
                Log.i("myLog", "File already exists!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("myLog", "Caught write exception!");
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            Log.i("myLog", "Write stack trace is:\n" + sw.toString());
        }

    }

    public static void readConfig(File myDir) {
        String filename = "myObject";
        //File myDir = getFilesDir();
        FileInputStream fis = null;
        ObjectInputStream get = null;
        try {
            File secondFile = new File(myDir + "/objects/", filename);
            fis = new FileInputStream(secondFile);
            get = new ObjectInputStream(fis);
            //Retrieved the saved object with Schedule arrays
            Sched_Config sched_retrieve = (Sched_Config) get.readObject();
            get.close();
            fis.close();
            Log.i("myLog", "File Retrieved!");
            //Make sure retrieved object is working properly
            Log.i("myLog", "Schedule[9] temp is " + sched_retrieve.schedules[9].temp);//Make sure retrieved object is working properly

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("myLog", "Caught read exception!");
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            Log.i("myLog", "Read stack trace is:\n" + sw.toString());
        }
    }

}
