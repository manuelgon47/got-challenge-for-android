package es.npatarino.android.gotchallenge.webservice;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import es.npatarino.android.gotchallenge.utils.Constants;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class GotHttpClient implements IGotClient {

    private static final String BASE_URL = "https://project-8424324399725905479.firebaseio.com/";

    private IGotClientListener listener;

    /**
     * Constructor with the listener
     *
     * @param listener Listener to handle the response
     */
    public GotHttpClient(IGotClientListener listener) {
        this.listener = listener;
    }

    @Override
    public void get(String endpoint) {
        doRequest("GET", endpoint);
    }

    @Override
    public void post(String endpoint) {
        doRequest("POST", endpoint);
    }

    private void doRequest(final String verb, final String endpoint) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    URL obj = new URL(BASE_URL + endpoint);
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    con.setRequestMethod(verb);
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    listener.responseOk(response.toString());
                } catch (IOException e) {
                    Log.e(Constants.TAG_DEBUG, "Error making a request", e);
                    listener.responseError();
                }
            }
        }).start();
    }


}
