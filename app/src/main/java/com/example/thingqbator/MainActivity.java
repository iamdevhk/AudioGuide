package com.example.thingqbator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.support.design.widget.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.fab);
        //FAB.setImageResource(R.drawable.ehy);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent al = new Intent(MainActivity.this, alar.class);

                // Start the new activity
                startActivity(al);
            }
        });
    }
    public void audio(View view) {

       Intent log = new Intent(MainActivity.this, audiophnnum.class);

        // Start the new activity
        startActivity(log);

    }
    public void visit(View view) {
        Intent log = new Intent(MainActivity.this, scanne.class);

        // Start the new activity
        startActivity(log);


    }
}
