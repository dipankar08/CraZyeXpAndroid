/***************************************
 *  Build the understanding of Touch Frame Work.
 *  1. setOnTouchListener propagate from child to parent
 *  2. propagate  only when we return fasle, Returning true means we are hadaing and do not propagate.. cool
 *  3. setOnclickEvent() will surpress touch event.
 *  4.
 */
package com.dipankar.crazyexpandroid.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class tutorial32 extends ActionBarActivity {
    private LinearLayout linLayout1,linLayout2,linLayout3,linLayout4,linLayout5;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial32);
        Toast.makeText(getApplicationContext(), "----VE clicked", Toast.LENGTH_LONG).show();

        linLayout1 = (LinearLayout) findViewById(R.id.layout1);
        linLayout2 = (LinearLayout) findViewById(R.id.layout2);
        linLayout3 = (LinearLayout) findViewById(R.id.layout3);
        linLayout4 = (LinearLayout) findViewById(R.id.layout4);
        b = (Button) findViewById(R.id.b);

        //On Touch Process from Buttonm Up
        linLayout1.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(    View v,    MotionEvent event){
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("DIPANKAR", "DOWN at linLayout1");
                }
                return false;
            }
        });
        linLayout2.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(    View v,    MotionEvent event){
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("DIPANKAR", "DOWN at linLayout2");
                }
                return false;
            }
        });
        linLayout3.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(    View v,    MotionEvent event){
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("DIPANKAR", "DOWN at linLayout3");
                }
                return true;
            }
        });

        linLayout4.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(    View v,    MotionEvent event){
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("DIPANKAR", "DOWN at linLayout4");
                }
                return false;
            }
        });
        b.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(    View v,    MotionEvent event){
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.d("DIPANKAR", "DOWN at b");
                }
                return false;
            }
        });

    }
    /* 3.  Click Oberwrite the Touch Event
    public void executeHello(View v) {
        Toast.makeText(this, "Hello World clicked...", Toast.LENGTH_LONG).show();
    }
    */
}
