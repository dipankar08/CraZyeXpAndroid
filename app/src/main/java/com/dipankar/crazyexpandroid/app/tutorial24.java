// Animation Hwhile activity Trasition.
package com.dipankar.crazyexpandroid.app;

        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.app.Activity;
        import android.content.Intent;

public class tutorial24 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial24);

        Button switchButton = (Button)findViewById(R.id.switchbutton);
        switchButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(tutorial24.this, tutorial24_next.class);
                startActivity(intent);
                //The two ints you provide for overridePendingTransition(int exitAnim, int enterAnim)
                // correspond to the two animations - removing the old Activity and adding the new one.
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }});
    }

}
