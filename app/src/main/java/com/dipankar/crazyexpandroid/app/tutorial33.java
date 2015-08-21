/* Invisble App for tapjacking */
package com.dipankar.crazyexpandroid.app;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class tutorial33 extends ActionBarActivity {
    private static Context sContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial33);
        Toast.makeText(getApplicationContext(), "----VE clicked", Toast.LENGTH_LONG).show();
        sContext = getApplicationContext();
    }
    public void executeHello(View v) {
        Toast.makeText(this, "Hello World clicked...", Toast.LENGTH_LONG).show();
    }

    public void launchBackgroundInstallDemo(View v) {
        Intent serviceIntent = new Intent(sContext,BackgroundInstallerService.class);
        sContext.startService(serviceIntent);
        onBackPressed();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //    finish();

    }
}

