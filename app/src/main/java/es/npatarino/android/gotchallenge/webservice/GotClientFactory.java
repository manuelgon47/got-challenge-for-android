package es.npatarino.android.gotchallenge.webservice;

/**
 * Created by Manuel González Villegas on 25/9/16.
 */
public class GotClientFactory {

    public static IGotClient getClient(IGotClientListener listener) {

        return new GotHttpClient(listener);
    }
}
