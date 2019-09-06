package com.example.thingqbator;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class send extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute

    public send(Context context) {
        this.context = context;
    }


   // String response;
    public String ju = scanne.us; //getting string from a activity to class
    public String ind = phonenumtwo.numm;

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk", "Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response


        String url = "http://192.168.43.132/thingq/insertboth.php?sno="+ju+"&phone="+ind;
        Log.v("Hk", url);
        String jsonStr = sh.makeServiceCall(url);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {



        Toast.makeText(this.context, "you have successfully registered please click retrieve audio", Toast.LENGTH_SHORT).show(); //use this context for showing toast in class
        context.startActivity(new Intent(context, MainActivity.class));


    }
}
