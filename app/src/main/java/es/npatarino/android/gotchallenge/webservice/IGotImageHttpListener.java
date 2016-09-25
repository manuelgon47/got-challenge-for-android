package es.npatarino.android.gotchallenge.webservice;

import android.graphics.Bitmap;

/**
 * Created by Manuel González Villegas on 25/9/16.
 */
public interface IGotImageHttpListener {
    void onImageRetrieved(Bitmap bitmap);

    void onError();

}
