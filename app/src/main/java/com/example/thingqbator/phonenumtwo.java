package com.example.thingqbator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

public class phonenumtwo extends AppCompatActivity {
    public String n;
    private Spinner spinner;
    private EditText editText;
    //CountryData c=new CountryData();
    public static String numm=" ";
    public static String phonenumber=" ";
    /*Context context;
    public audiophnnum(Context context) {
        this.context = context;
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonenumtwo);

        spinner = findViewById(R.id.spinnerCountries);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));

        editText = findViewById(R.id.editTextPhone);
    }
      /*  findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];

                String number = editText.getText().toString().trim();
               numm=number;
                if (number.isEmpty() || number.length() < 10) {
                    editText.setError("Valid number is required");
                    editText.requestFocus();
                    return;
                }

                phonenumber = "+" + code + number;
                //getresponse hu =new getresponse(this.getApplicationContext());
                //hu.execute();
                new getresponse(context).execute();
                /*Intent intent = new Intent(audiophnnum.this, OtpActivity.class);
                intent.putExtra("phonenumber", phonenumber);
                intent.putExtra("number",numm);
                startActivity(intent);*/

    public void works(View view) {
        //tent log = new Intent(audiophnnum, audiophnnum.class);

        // Start the new activity
        String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];

        String number = editText.getText().toString().trim();
        numm=number;
        if (number.isEmpty() || number.length() < 10) {
            editText.setError("Valid number is required");
            editText.requestFocus();
            return;

        }

        phonenumber = "+" + code + number;
        response hu =new response(this.getApplicationContext());
        hu.execute();


    }

}

