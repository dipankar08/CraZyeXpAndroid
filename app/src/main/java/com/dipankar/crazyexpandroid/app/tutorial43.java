/* This is a Templete You should Copy this to crete a new one... ha ha ha */
package com.dipankar.crazyexpandroid.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class tutorial43 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial43);
        Toast.makeText(getApplicationContext(), "----VE clicked", Toast.LENGTH_LONG).show();
    }
    public void executeHello(View v) {
        Toast.makeText(this, "Hello World clicked...", Toast.LENGTH_LONG).show();
    }
}
