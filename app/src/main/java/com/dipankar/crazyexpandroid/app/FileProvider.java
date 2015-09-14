package com.dipankar.crazyexpandroid.app;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public class FileProvider extends ContentProvider {
    public static final Uri CONTENT_URI=Uri.parse("content://com.dipankar.crazyexpandroid.app/");
    private static final HashMap<String, String> MIME_TYPES=new HashMap<String, String>();

    static {
        MIME_TYPES.put(".pdf", "application/pdf");
    }

    @Override
    public boolean onCreate() {
        Log.d("DIPANKAR","=====> FileProvider On Crete called....");
        File f=new File(getContext().getFilesDir(), "test.pdf");
        if (!f.exists()) {
            AssetManager assets=getContext().getResources().getAssets();
            try {
//                copy(assets.open("test.pdf"), f);
            }
            catch (Exception e) {
                Log.e("FileProvider", "Exception copying from assets", e);
                return(false);
            }
        }
        return(true);
    }

    @Override
    public String getType(Uri uri) {
        String path=uri.toString();
        for (String extension : MIME_TYPES.keySet()) {
            if (path.endsWith(extension)) {
                return(MIME_TYPES.get(extension));
            }
        }
        return(null);
    }

    @Override
    public ParcelFileDescriptor openFile(Uri uri, String mode)
            throws FileNotFoundException {
        Log.d("DIPANKAR","------------------>Got a call for Open File");
        File f=new File(getContext().getFilesDir(), uri.getPath());
        try {
            if (f.createNewFile()){
                Log.d("Dipankar", "Writing file....." + f.getAbsolutePath());
                OutputStream os = new FileOutputStream(f.getAbsolutePath());
                os.write(("Hello Dipankar from: " + f.getAbsolutePath()).getBytes());
                os.flush();
                os.close();
                String str = "Verify Write:===> " + "Hello Dipankar from:" + f.getAbsolutePath();
               // Toast.makeText(this, "hello", Toast.LENGTH_LONG ).show();
            }else{
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (f.exists()) {
            return(ParcelFileDescriptor.open(f,
                    ParcelFileDescriptor.MODE_READ_ONLY));
        }
        throw new FileNotFoundException(uri.getPath());
    }

    @Override
    public Cursor query(Uri url, String[] projection, String selection,
                        String[] selectionArgs, String sort) {
        throw new RuntimeException("Operation not supported");
    }

    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        throw new RuntimeException("Operation not supported");
    }

    @Override
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
        throw new RuntimeException("Operation not supported");
    }

    @Override
    public int delete(Uri uri, String where, String[] whereArgs) {
        throw new RuntimeException("Operation not supported");
    }

    static private void copy(InputStream in, File dst) throws IOException {
        FileOutputStream out=new FileOutputStream(dst);
        byte[] buf=new byte[1024];
        int len;

        while((len=in.read(buf))>0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }
}