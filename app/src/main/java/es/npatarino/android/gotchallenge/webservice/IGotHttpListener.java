package es.npatarino.android.gotchallenge.webservice;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public interface IGotHttpListener {
    /**
     * Response from server is Ok
     *
     * @param response Response JSON
     */
    void responseOk(StringBuffer response);

    /**
     * Response from server is error
     */
    void responseError();
}
