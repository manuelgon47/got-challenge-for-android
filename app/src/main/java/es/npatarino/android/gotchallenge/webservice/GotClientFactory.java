package es.npatarino.android.gotchallenge.webservice;

import android.app.Activity;

/**
 * Created by Manuel González Villegas on 25/9/16.
 */
public class GotClientFactory {

    public static IGotClient getClient(Activity activity, IGotClientListener listener) {

        return new GotHttpClient(listener);
    }
}
