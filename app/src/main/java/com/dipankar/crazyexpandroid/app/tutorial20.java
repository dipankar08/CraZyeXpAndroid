/* This is a Templete You should Copy this to crete a new one... ha ha ha */
package com.dipankar.crazyexpandroid.app;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class tutorial20 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial20);
        Toast.makeText(getApplicationContext(), "----VE clicked", Toast.LENGTH_LONG).show();
    }
    public void executeHello(View v) {
        Toast.makeText(this, "ShutDown", Toast.LENGTH_LONG).show();
        //Intent i = new Intent("android.intent.action.ACTION_REQUEST_SHUTDOWN");
        //i.putExtra("android.intent.extra.KEY_CONFIRM", true);
        //
        // startActivity(i);
        PowerManager manager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = manager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "Your Tag");
        wl.acquire();
        wl.release();

    }
}
