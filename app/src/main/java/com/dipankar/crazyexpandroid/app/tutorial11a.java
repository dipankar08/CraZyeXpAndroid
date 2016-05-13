/* Copy Paste Example using ClipboardManager */
package com.dipankar.crazyexpandroid.app;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;


public class tutorial11a extends ActionBarActivity {

    private ClipboardManager myClipboard;
    private ClipData myClip;
    private EditText copyField;
    private TextView logT;
    private static Context mContext ;
    private CheckBox chk1,chk2;

    public void log(String str){
        logT.setText(str);
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
        Log.d("DIPANKAR",str);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Dipankar", "Start my application...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial11a);
        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        copyField = (EditText)findViewById(R.id.editText1);
        logT = (TextView) findViewById(R.id.log);
        chk1 = (CheckBox) findViewById(R.id.checkBox1);
        chk2 = (CheckBox) findViewById(R.id.checkBox2);
        mContext = getApplicationContext();
    }

    @SuppressLint("NewApi")
    public void copy(View view){
        String text = copyField.getText().toString();
        myClip = ClipData.newPlainText("text", text);
        myClipboard.setPrimaryClip(myClip);
        log("Text Copied");
    }
    @SuppressLint("NewApi")
    public void clear(View view){
        copyField.setText("");
        log( "Cleared the text box only.. not clear the clipboard ..:)");
    }

    @SuppressLint("NewApi")
    public void paste(View view){
        log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  new paste iteration <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        if (myClipboard.hasPrimaryClip() && myClipboard.getPrimaryClipDescription().hasMimeType(
                ClipDescription.MIMETYPE_TEXT_HTML)) {
                log("DIPANKAR: WE HAVE HTML CONETENT");
        } else {
                log("DIPANKAR: WE HAVE NO HTML CONETENT");
        }

        ClipData.Item item = myClipboard.getPrimaryClip().getItemAt(0);

        if (chk1.isChecked()) {
            log("DIPANKAR: TRYING TO GET HTML TEXT");
            copyField.setText(item.getHtmlText());
        } else {
            log("DIPANKAR: TRYING TO GET PLAIN TEXT");
            copyField.setText(item.getText());
        }
        log("DIPANKAR: item.getHtmlText()::"+ item.getHtmlText());
        log("DIPANKAR: item.getText()::"+item.getText().toString());

        log("Text Pasted");
    }
}

