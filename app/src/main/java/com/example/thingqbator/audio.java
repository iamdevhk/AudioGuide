package com.example.thingqbator;


import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import java.io.IOException;
import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.jsoup.nodes.Document;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class audio extends AppCompatActivity {
    public static String ju=" ";
    String a=" ";
    String singleParsed1="";
    String data;
    public static String h=" ";
    Button buttonStop,buttonStart ;
    public static String title="";
    public String title1="";
    MediaPlayer mediaplayer;
    public static String src="";
    private ProgressDialog mProgressDialog;
    //ju=audiophnnum.numm;
    // private String url = "https://sanjau8.github.io/Arithmeticia/first_page.html";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        h = getIntent().getStringExtra("asd");
        ju=audiophnnum.numm;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("Main", "Permission is granted");
                //return true;
            } else {

                Log.v("Main", "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                //return false;
            }
        } else {
            int permission = PermissionChecker.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (permission == PermissionChecker.PERMISSION_GRANTED) {
                // good to go
                Log.v("Main", "Permission is granted");
            } else {
                // permission not granted, you decide what to do
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }


        }
        new Description().execute();
    }

    private class Description extends AsyncTask<Void, Void, Void> {
        String desc;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(audio.this);
            mProgressDialog.setTitle("Android Basic JSoup Tutorial");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                Document mBlogDocument = Jsoup.connect("https://bulbcontrol.000webhostapp.com/thingq/showaudio.php").get();
                // Using Elements to get the Meta data
                // Log.v("Hk",url);
                title=mBlogDocument.title();
                Log.v("Hk",title);
                src = mBlogDocument.select("audio#wav").first().attr("src");
                Element links = mBlogDocument.getElementsByTag("p").first();
                title1=links.text();
                Log.v("Hkay",title1);
                //  String src = mBlogDocument.select("audio[id=jp_audio_0]").first().attr("src");
                // Elements audio=mBlogDocument.getElementsByTag("audio");
                // for(Element src :audio) {
                //title1 = src.attr("src");
                // title2 = src.text();
                //Log.v("hy",title2);
                //}e
                //Log.e("hy",title2);
                //Elements links = content.getElementsByTag("a");
                /// for (Element link : links) {

                // String displaythisgoddammit = "display this goddammit"
                //Elements mElementDataSize = mBlogDocument.select("div[class=rules]");
                // Locate the content attribute
                // int mElementSize = mElementDataSize.size();

                /*for (int i = 0; i < mElementSize; i++) {
                    Elements mElementAuthorName = mBlogDocument.select("div[class=rules]").eq(i);
                    String mAuthorName = mElementAuthorName.text();

                    Elements mElementBlogUploadDate = mBlogDocument.select("div[class=rules]").eq(i);
                    String mBlogUploadDate = mElementBlogUploadDate.text();

                   Elements mElementBlogTitle = mBlogDocument.select("div[class=rules]").select("a").eq(i);
                    String mBlogTitle = mElementBlogTitle.text();

                    mAuthorNameList.add(mAuthorName);
                    mBlogUploadDateList.add(mBlogUploadDate);
                    mBlogTitleList.add(mBlogTitle);*/
                // }
            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set description into TextView

          /*  RecyclerView mRecyclerView = (RecyclerView)findViewById(R.id.act_recyclerview);

            //DataAdapter mDataAdapter = new DataAdapter(MainActivity.this, mBlogTitleList, mAuthorNameList, mBlogUploadDateList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mDataAdapter);*/

            mProgressDialog.dismiss();
            //Log.v("hy",title2);
            TextView text = (TextView) findViewById(R.id.my_text_view);
            text.setText(src);
            Button button = (Button) findViewById(R.id.audio);
            buttonStart = (Button)findViewById(R.id.button1);
            buttonStop = (Button)findViewById(R.id.button2);
            mediaplayer = new MediaPlayer();
            mediaplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            buttonStart.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    try {

                        mediaplayer.setDataSource("https://bulbcontrol.000webhostapp.com/thingq/"+src);
                        mediaplayer.prepare();


                    } catch (IllegalArgumentException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (SecurityException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    mediaplayer.start();


                }
            });

            buttonStop.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub


                    mediaplayer.stop();


                }
            });

            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                    //String hey="https://bulbcontrol.000webhostapp.com/thingq/"+src;
                    Uri uri = Uri.parse("https://bulbcontrol.000webhostapp.com/thingq/"+src);
                    Log.v("heyy",uri.toString());
                    DownloadManager.Request req = new DownloadManager.Request(uri);
                    req.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    String filename = "audioguide";
                    filename += ".mp3";
                    req.setDestinationInExternalPublicDir("/Downaudio", filename);
                    //StyleableToast.makeText(getBaseContext(), "Download Started", Toast.LENGTH_SHORT, R.style.mytoast).show();
                    Toast.makeText(getBaseContext(),"downloading",Toast.LENGTH_LONG).show();
                    Long ref = dm.enqueue(req);
                    //  DownloadManagerActivity d= new DownloadManagerActivity();
                    // d.download();
                    //Intent log = new Intent(MainActivity.this, test.class);

                    // Start the new activity
                    // startActivity(log);

                }
            });


        }
    }




    public void download(View view) {


         //ju=audiophnnum.numm;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://192.168.43.132/thingq/showaudio.php?ju="+ju));
        if (intent.resolveActivity(getPackageManager()) != null) { //always use this format to open from intent
            startActivity(Intent.createChooser(intent, "Open Link"));//removed context use it with creating context constructor commented out at get response class
        }

    }
}
