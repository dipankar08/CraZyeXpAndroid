/* [working..]Tween Animation Animation
 *
  * cick button on action bar */
package com.dipankar.crazyexpandroid.app;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class tutorial15 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial15);
        //getActionBar().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        switch(item.getItemId())
        {
            case R.id.zoomInOut:
                //Step1: Get the element
                //Step2: get the Animation
                //Step3: Apply the animation on the element
                ImageView image = (ImageView)findViewById(R.id.imageView1);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
                image.startAnimation(animation);
                return true;
            case R.id.rotate360:
                ImageView image1 = (ImageView)findViewById(R.id.imageView1);
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
                image1.startAnimation(animation1);
                return true;
            case R.id.fadeInOut:
                ImageView image2 = (ImageView)findViewById(R.id.imageView1);
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                image2.startAnimation(animation2);
                return true;

        }
        return false;
    }

}
