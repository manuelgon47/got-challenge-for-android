package es.npatarino.android.gotchallenge.webservice;

/**
 * Created by Manuel González Villegas on 25/9/16.
 */
public interface IGotClient {

    void get(String endpoint);

    void post(String endpoint);
}
