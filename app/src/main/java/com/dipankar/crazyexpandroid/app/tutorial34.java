/* This is a Templete You should Copy this to crete a new one... ha ha ha */
package com.dipankar.crazyexpandroid.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

public class tutorial34 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial34);
        Toast.makeText(getApplicationContext(), "----VE clicked", Toast.LENGTH_LONG).show();
    }
    public void executeHello(View v) {
        showSimpleDialog();
    }
    /* Ok and Cacle Button */
    public void showSimpleDialog() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(tutorial34.this);

        // set title

        alertDialogBuilder.setTitle("This is title");
       // alertDialogBuilder.setIcon(R.drawable.sample);

        // set dialog message
        alertDialogBuilder
                .setMessage("This is the message")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        tutorial34.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }
    /* Ok Button Only */
    public void getOkDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(tutorial34.this);        // set title

        alertDialogBuilder.setTitle("Invisible Activity found! ");
        // alertDialogBuilder.setIcon(R.drawable.sample);

        // set dialog message
        alertDialogBuilder
                .setMessage("This is the message")
                .setCancelable(false)
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // if this button is clicked, close
                // current activity
                tutorial34.this.finish();
            }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }

}
