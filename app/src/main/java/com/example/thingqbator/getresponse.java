package com.example.thingqbator;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class getresponse extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute

    public getresponse(Context context) {
        this.context = context;
    }


    String response;
    public String ju = audiophnnum.numm; //getting string from a activity to class
    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk","Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response


        String url = "http://192.168.43.132/thingq/phonechk.php?phone="+ju;
        Log.v("Hk",url);
        String jsonStr = sh.makeServiceCall(url);
        //Log.v("Hk",jsonStr);
        //Log.e("MainActivity", "Response from url: " + jsonStr);
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                response = jsonObj.getString("phone");
                Log.v("Hk",response);

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
        String ans= response;

        if(ans.equals(ju)) //strings cant be compared directly like javascript
        {
            /*Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://192.168.43.132/thingq/showaudio.php?ju="+ju));
            if (intent.resolveActivity(context.getPackageManager()) != null) { //always use this format to open from intent
                context.startActivity(Intent.createChooser(intent, "Open Link"));
            }*/
           // Intent intent = new Intent(audiophnnum.this, OtpActivity.class);
            //Bundle b=getIntent().getExtras();
            //audio.setText(this.singleParsed1);
            context.startActivity(new Intent(context,OtpActivity.class));
            //intent.putExtra("phonenumber", audiophnnum.phonenumber);
           // intent.putExtra("number",audiophnnum.numm);
           // context.startActivity(intent);
        }
        else{
            Toast.makeText(this.context, "please click new visit and register", Toast.LENGTH_SHORT).show(); //use this context for showing toast in class
            context.startActivity(new Intent(context,MainActivity.class));
        }
    }

}
