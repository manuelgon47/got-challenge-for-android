package es.npatarino.android.gotchallenge.utils;

import android.graphics.Bitmap;

import es.npatarino.android.gotchallenge.webservice.GotImageHttpClient;
import es.npatarino.android.gotchallenge.webservice.IGotImageHttpListener;

/**
 * Created by Manuel González Villegas on 25/9/16.
 */
public class ImageFactory {

    public interface ImageFactoryListener {
        void onImageRetrieved(Bitmap bitmap);

        void onError();
    }

    public void getImage(String url, final ImageFactoryListener listener) {
        new GotImageHttpClient(new IGotImageHttpListener() {
            @Override
            public void onImageRetrieved(Bitmap bitmap) {
                listener.onImageRetrieved(bitmap);
            }

            @Override
            public void onError() {
                listener.onError();
            }
        }).getImageBitmap(url);
    }

}
