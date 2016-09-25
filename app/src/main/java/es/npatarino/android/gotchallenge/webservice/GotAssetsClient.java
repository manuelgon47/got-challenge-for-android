package es.npatarino.android.gotchallenge.webservice;

import android.app.Activity;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

import es.npatarino.android.gotchallenge.utils.Constants;

/**
 * Created by Manuel González Villegas on 25/9/16.
 */
public class GotAssetsClient implements IGotClient {

    private IGotClientListener listener;
    private Activity activity;

    /**
     * Constructor with the listener
     *
     * @param listener Listener to handle the response
     */
    public GotAssetsClient(Activity activity, IGotClientListener listener) {
        this.listener = listener;
        this.activity = activity;
    }

    @Override
    public void get(String endpoint) {
        doRequest(endpoint);
    }

    @Override
    public void post(String endpoint) {
        doRequest(endpoint);
    }

    private void doRequest(final String endpoint) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    InputStream is = activity.getAssets().open(endpoint);
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    String json = new String(buffer, "UTF-8");

                    listener.responseOk(json);
                } catch (IOException e) {
                    Log.e(Constants.TAG_DEBUG, "Error reading json file", e);
                    listener.responseError();
                }
            }
        }).start();
    }
}
