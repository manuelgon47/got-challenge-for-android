package es.npatarino.android.gotchallenge.webservice.services;

import android.app.Activity;
import android.graphics.Bitmap;

import es.npatarino.android.gotchallenge.utils.ImageFactory;

/**
 * Created by Manuel González Villegas on 25/9/16.
 */
public class GotCharacterImageService {

    private Activity activity;

    public interface GotCharacterImageServiceListener {
        void onImageRetrieved(Bitmap bitmap);
        void onError();
    }

    public GotCharacterImageService(Activity activity) {
        this.activity = activity;
    }

    public void getCharacterImage(String imageUrl, final GotCharacterImageServiceListener listener) {
        new ImageFactory().getImage(activity, imageUrl, new ImageFactory.ImageFactoryListener() {
            @Override
            public void onImageRetrieved(Bitmap bitmap) {
                listener.onImageRetrieved(bitmap);
            }

            @Override
            public void onError() {
                listener.onError();
            }
        });
    }

}
