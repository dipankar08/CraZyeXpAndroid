/* View Properties Animator */
package com.dipankar.crazyexpandroid.app;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class tutorial22 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial22);

        final LinearLayout container = (LinearLayout) findViewById(R.id.container);

        final Button fadeOut = (Button) findViewById(R.id.fadeOut);
        final Button fadeIn = (Button) findViewById(R.id.fadeIn);
        final Button moveOver = (Button) findViewById(R.id.moveOver);
        final Button moveBack = (Button) findViewById(R.id.moveBack);
        final Button rotate = (Button) findViewById(R.id.rotate);
        final Button animatingButton = (Button) findViewById(R.id.animatingButton);
        // Set long default duration for the animator, for the purposes of this demo
        animatingButton.animate().setDuration(2000);

        fadeOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatingButton.animate().alpha(0);
            }
        });

        fadeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatingButton.animate().alpha(1);
            }
        });

        moveOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int xValue = container.getWidth() - animatingButton.getWidth();
                int yValue = container.getHeight() - animatingButton.getHeight();
                animatingButton.animate().x(xValue).y(yValue);
            }
        });

        moveBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatingButton.animate().x(0).y(0);
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatingButton.animate().rotationXBy(1720);
            }
        });
    }
}
