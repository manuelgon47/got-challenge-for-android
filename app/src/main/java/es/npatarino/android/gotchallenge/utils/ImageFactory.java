package es.npatarino.android.gotchallenge.utils;

import android.app.Activity;
import android.graphics.Bitmap;

import es.npatarino.android.gotchallenge.webservice.GotImageAssetsClient;
import es.npatarino.android.gotchallenge.webservice.IGotImageListener;

/**
 * Created by Manuel González Villegas on 25/9/16.
 */
public class ImageFactory {

    public interface ImageFactoryListener {
        void onImageRetrieved(Bitmap bitmap);

        void onError();
    }

    public void getImage(Activity activity, String url, final ImageFactoryListener listener) {
        new GotImageAssetsClient(activity, new IGotImageListener() {
            @Override
            public void onImageRetrieved(Bitmap bitmap) {
                listener.onImageRetrieved(bitmap);
            }

            @Override
            public void onError() {
                listener.onError();
            }
        }).getImageBitmap("imagen_no_disponible.png");
    }

}
