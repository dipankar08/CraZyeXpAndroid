/* Example of StateList Droable */
package com.dipankar.crazyexpandroid.app;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class tutorial30 extends Activity implements OnClickListener{

    RelativeLayout contentView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contentView = new RelativeLayout(this);

        // CREATE OUR CUSTOM STATE LIST DRAWABLE
        StateListDrawable drawable = new StateListDrawable();


        // ON PRESS/CLICK BACKGROUND
        drawable.addState(new int[] {android.R.attr.stateNotNeeded},new ColorDrawable(Color.BLACK));
        drawable.addState(new int[]{android.R.attr.state_pressed},new ColorDrawable(Color.RED));
        drawable.addState(new int[] {android.R.attr.state_focused}, new ColorDrawable(Color.YELLOW));
        drawable.addState(new int[] {android.R.attr.state_enabled},new ColorDrawable(Color.BLUE));
        // DEFAULT BACKGROUND
        drawable.addState(new int[]{}, new ColorDrawable(Color.GREEN));



        // CREATE OUR PARAM
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        // CREATE OUR TEXTVIEW
        textView = new TextView(this);
        textView.setText("Click Me");
        textView.setLayoutParams(params);

        // SET STATELISTDRAWABLE AS BACKGROUND
        textView.setBackgroundDrawable(drawable);
        contentView.setBackgroundDrawable(drawable);

        textView.setPadding(50, 50, 50, 50);

        // SET CLICK LISTENER
        textView.setOnClickListener(this);

        contentView.addView(textView);

        setContentView(contentView);
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
    }
}
