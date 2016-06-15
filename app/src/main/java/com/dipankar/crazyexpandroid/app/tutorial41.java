/* This is a Templete You should Copy this to crete a new one... ha ha ha */
package com.dipankar.crazyexpandroid.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class tutorial41 extends ActionBarActivity implements View.OnTouchListener {
    int i =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial41);
        Toast.makeText(getApplicationContext(), "----VE clicked", Toast.LENGTH_LONG).show();
    }
    public void executeHello(View v) {
        Toast.makeText(this, "Hello World clicked...", Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            Log.w("onKeyDown", "LONG KEYCODE_VOLUME_DOWN:"+(i++));
            //Note : You must return false always to indicate the solund voluem echnages
            return false;
        }
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            Log.w("onKeyDown", "LONG KEYCODE_VOLUME_UP:"+(i++));
            return false;
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {
            Log.w("onKeyDown", "KEYCODE_VOLUME_DOWN:" + (i++));
            event.startTracking();
            return true;
        }
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            Log.w("onKeyDown", "KEYCODE_VOLUME_UP:"+(i++));

            event.startTracking();
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
/**************************
 * Notes:
 *  1. Return false to do the default work like raise the sound
 ******************************/