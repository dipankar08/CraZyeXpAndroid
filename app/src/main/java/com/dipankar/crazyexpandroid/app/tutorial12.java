/* NOT WORKING Text to speecha and Sppech to text using Android.*/
package com.dipankar.crazyexpandroid.app;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import java.util.Locale;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tutorial12 extends Activity implements TextToSpeech.OnInitListener {
    int MY_DATA_CHECK_CODE = 1;
    private TextToSpeech mTts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial12);

        PackageManager pm = getPackageManager();
        Intent installIntent = new Intent();
        installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
        ResolveInfo resolveInfo = pm.resolveActivity( installIntent, PackageManager.MATCH_DEFAULT_ONLY );

        if( resolveInfo == null ) {
            // Not able to find the activity which should be started for this intent
            Log.d("ll","jjj");
        } else {
            startActivity( installIntent );
        }
    }

    protected void onActivityResult(
            int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // success, create the TTS instance
                mTts = new TextToSpeech(this, this);
            } else {
                // missing data, install it
                Toast.makeText(getApplicationContext(), "installing...", Toast.LENGTH_LONG).show();
                Intent installIntent = new Intent();
                installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installIntent);
                finish();
            }
        }
    }

    @Override
    public void onInit(int status) {
        mTts.setLanguage(Locale.US);
        mTts.speak("hai this is for testing, Karhtik is testing this application", TextToSpeech.QUEUE_FLUSH, null);
    }
}
