//Listner
package com.dipankar.crazyexpandroid.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tutorial31 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial31);
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Log.d("Dip+ankar","Click Evnet");
            }});
        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                Log.d("Dipankar","Touch Evnet");
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    Log.d("Dipankar","Touch Down");
                    return true;
                }
                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Log.d("Dipankar","Touch Up");
                    return true;
                }
                return false;
            }
        });
    }

}
