package com.example.thingqbator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;



public class scanne extends AppCompatActivity {

    TextView tvCardText;
    // TextView tvCardTextt;
    Button btStartScan;
    public static String us=" ";
    String s;
    String a;
    String h;
    String d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanne);


        btStartScan = (Button)findViewById(R.id.btn_scan);
        btStartScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQRScanner();
            }
        });




    }

    private void startQRScanner() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setOrientationLocked(false);
        integrator.setPrompt("Scan a QR-Code");
        integrator.initiateScan();


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result =   IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            us=result.getContents();

            if (us == null) {
                Toast.makeText(this,    "Cancelled",Toast.LENGTH_LONG).show();
            } else {

                Intent intent = new Intent(scanne.this, phonenumtwo.class);

                startActivity(intent);

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);


        }
    }



}