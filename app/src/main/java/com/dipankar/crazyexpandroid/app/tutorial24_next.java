
package com.dipankar.crazyexpandroid.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class tutorial24_next extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial24_next);

        Button switchButton = (Button)findViewById(R.id.switchbutton);
        switchButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(tutorial24_next.this, tutorial24.class);
                startActivity(intent);
                overridePendingTransition(R.anim.top_out, R.anim.bottom_in);
            }});
    }

}
