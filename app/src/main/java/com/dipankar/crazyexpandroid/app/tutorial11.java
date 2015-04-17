/* Copy Paste Example using ClipboardManager */
package com.dipankar.crazyexpandroid.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.io.InputStream;
import java.net.URL;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class tutorial11 extends ActionBarActivity {

    private ClipboardManager myClipboard;
    private ClipData myClip;
    private EditText copyField,pasteField;
    ImageView img;
    Bitmap bitmap;
    ProgressDialog pDialog;
    LinearLayout notes ;
    private static Context mContext ;
    java.util.List<String> pendingImageList= new java.util.ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Dipankar", "Start my application...");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial11);
        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        copyField = (EditText)findViewById(R.id.editText1);
        pasteField = (EditText)findViewById(R.id.editText2);
        notes = (LinearLayout)  findViewById(R.id.LinearLayout1);
        mContext = getApplicationContext();

        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        BroadcastReceiver mNetworkStateIntentReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(
                        ConnectivityManager.CONNECTIVITY_ACTION)) {

                    NetworkInfo info = intent.getParcelableExtra(
                            ConnectivityManager.EXTRA_NETWORK_INFO);
                    String typeName = info.getTypeName();
                    String subtypeName = info.getSubtypeName();
                    System.out.println("Internet Connectivity changed ! ******** "+typeName+":::"+subtypeName);

                    if( checkInternetConnection()== true )
                    {
                        Log.d("Dipankar","Internet get!");

                        for (String temp : pendingImageList) {
                            new LoadImage().execute(temp);
                        }

                    }
                    else{
                        Log.d("Dipankar","Internet gone!");
                    }
                }
            }
        };
        mContext.registerReceiver(mNetworkStateIntentReceiver, filter);

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
    public void paste(View view){
        ClipData abc = myClipboard.getPrimaryClip();
        ClipData.Item item = abc.getItemAt(0);
        String text = item.getText().toString();
        pasteField.setText(text);
        Toast.makeText(getApplicationContext(), "Text Pasted", Toast.LENGTH_SHORT).show();
        //loading the image
        new LoadImage().execute(text);
    }
    @SuppressLint("NewApi")
    public void checkInternetConnectionBtnClick(View view){
        if(checkInternetConnection()){
        Toast.makeText(getApplicationContext(), "Net exist!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "No Internet :(", Toast.LENGTH_SHORT).show();
        }
    }

    /* Internet connectivity logs is here */
    private boolean checkInternetConnection() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        // ARE WE CONNECTED TO THE NET

        if (conMgr.getActiveNetworkInfo() != null
                && conMgr.getActiveNetworkInfo().isAvailable()
                && conMgr.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }

    }




        /* Image load logic is here */
    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        String url;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(tutorial11.this);
            pDialog.setMessage("Loading Image ....");
            pDialog.show();

        }
        protected Bitmap doInBackground(String... args) {
            try {
                url = args[0];
                bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());

            } catch (Exception e) {
                Log.d("Dipankar", "Not able to load image ");
                e.printStackTrace();
            }
            return bitmap;
        }
        protected void onPostExecute(Bitmap image) {
            if(checkInternetConnection() == false){
                ImageView imageView = new ImageView(tutorial11.this);
                pendingImageList.add(url);
                notes.addView(imageView);
                pDialog.dismiss();

            }
            else if(image != null){
                ImageView imageView = new ImageView(tutorial11.this);
                imageView.setImageBitmap(image);
                notes.addView(imageView);
                pDialog.dismiss();
            }else{
                pDialog.dismiss();
                Toast.makeText(tutorial11.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

