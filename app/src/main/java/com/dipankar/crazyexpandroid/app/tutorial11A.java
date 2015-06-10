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
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;


public class tutorial11A extends ActionBarActivity {

    private ClipboardManager myClipboard;
    private ClipData myClip;
    private EditText copyField;
    private static Context mContext ;
    private CheckBox chk1,chk2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Dipankar", "Start my application...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial11a);
        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        copyField = (EditText)findViewById(R.id.editText1);
        chk1 = (CheckBox) findViewById(R.id.checkBox1);
        chk2 = (CheckBox) findViewById(R.id.checkBox2);
        mContext = getApplicationContext();
    }

    @SuppressLint("NewApi")
    public void copy(View view){
        String text = copyField.getText().toString();
        myClip = ClipData.newPlainText("text", text);
        myClipboard.setPrimaryClip(myClip);
        Toast.makeText(getApplicationContext(), "Text Copied",
                Toast.LENGTH_SHORT).show();
    }
    @SuppressLint("NewApi")
    public void clear(View view){
        copyField.setText("");
        Toast.makeText(getApplicationContext(), "Cleared...",Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("NewApi")
    public void paste(View view){
        if (myClipboard.hasPrimaryClip() && myClipboard.getPrimaryClipDescription().hasMimeType(
                ClipDescription.MIMETYPE_TEXT_HTML)) {
            // Get the very first item from the clip.
            Toast.makeText(getApplicationContext(), "Get HTML for paste", Toast.LENGTH_SHORT).show();
            ClipData.Item item = myClipboard.getPrimaryClip().getItemAt(0);
            if (chk1.isChecked()) {
                copyField.setText(item.getHtmlText());
            } else {
                // Paste the only text version.
                copyField.setText(item.getText());
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "NON HTML for paste", Toast.LENGTH_SHORT).show();
            // Paste the CoerceText .
            ClipData.Item item = myClipboard.getPrimaryClip().getItemAt(0);
            copyField.setText(item.coerceToText(this));
        }
        Toast.makeText(getApplicationContext(), "Text Pasted", Toast.LENGTH_SHORT).show();
    }
}

