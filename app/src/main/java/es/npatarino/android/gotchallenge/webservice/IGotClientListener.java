package es.npatarino.android.gotchallenge.webservice;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public interface IGotClientListener {
    /**
     * Response from server is Ok
     *
     * @param response Response JSON
     */
    void responseOk(String response);

    /**
     * Response from server is error
     */
    void responseError();
}
