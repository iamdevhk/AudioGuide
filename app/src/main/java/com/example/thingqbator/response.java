package com.example.thingqbator;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class response extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute

    public response(Context context) {
        this.context = context;
    }


    String response;
    public String ju = scanne.us;//getting string from a activity to class
    public String num = phonenumtwo.numm;

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk", "Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response


        String url = "http://192.168.43.132/thingq/checkexist.php?sno="+ ju+"&phone="+num;
        Log.v("Hk", url);
        String jsonStr = sh.makeServiceCall(url);
        //Log.v("Hk",jsonStr);
        //Log.e("MainActivity", "Response from url: " + jsonStr);
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                response = jsonObj.getString("sno");
                Log.v("Hk", response);

            } catch (final JSONException e) {
                Log.e("MainActivity", "Json parsing error: " + e.getMessage());
            }

        } else {
            Log.e("MainActivity", "Couldn't get json from server.");
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        String ans = response;

        if (ans.equals(ju)) //strings cant be compared directly like javascript
        {

            context.startActivity(new Intent(context, otpTwo.class));//the website should return the samed number if theres no entry for it

        } else if (ans.equals(87)) {//even while comparing numbers with string use equals fn
            Toast.makeText(this.context, "you have already registered please click retrieve audio", Toast.LENGTH_SHORT).show(); //use this context for showing toast in class
            context.startActivity(new Intent(context, MainActivity.class));
        } else {
            Toast.makeText(this.context, "hey en goli sodave", Toast.LENGTH_SHORT).show(); //use this context for showing toast in class
            context.startActivity(new Intent(context, MainActivity.class));
        }

    }
}
