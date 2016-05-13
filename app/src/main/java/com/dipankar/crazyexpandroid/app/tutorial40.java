/* This is a Templete You should Copy this to crete a new one... ha ha ha */
package com.dipankar.crazyexpandroid.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tutorial40 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial40);
        Toast.makeText(getApplicationContext(), "----VE clicked", Toast.LENGTH_LONG).show();
        while(true) {
            foo();
        }
    }

    public void executeHello(View v) {
        Toast.makeText(this, "Hello World clicked...", Toast.LENGTH_LONG).show();
    }

    void foo() {
        try {
            Runtime.getRuntime().exec("logcat -c").waitFor();
            Process process = Runtime.getRuntime().exec("logcat -v long *:*");
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (true) {
                String nextLine = reader.readLine();
                if (!nextLine.contains("LogWatcher-D")) {
                    Log.w("LogWatcher-D", "See: " + nextLine);
                }

                // Process line
            }
        } catch (Exception ex) {
            Log.e("Dipankar", "getLog failed", ex);
        }
    }
}


final class MyAppLogReader {

    private static final String TAG = MyAppLogReader.class.getCanonicalName();
    private static final String processId = Integer.toString(android.os.Process
            .myPid());

    public static StringBuilder getLog() {

        StringBuilder builder = new StringBuilder();

        try {
            String[] command = new String[] { "logcat", "-v", "threadtime" };

            Process process = Runtime.getRuntime().exec(command);

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(processId)) {
                    builder.append(line);
                    //Code here
                }
            }
        } catch (IOException ex) {
            Log.e(TAG, "getLog failed", ex);
        }

        return builder;
    }
}