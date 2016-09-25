package es.npatarino.android.gotchallenge.webservice.services;

import android.graphics.Bitmap;

import es.npatarino.android.gotchallenge.utils.ImageFactory;

/**
 * Created by Manuel González Villegas on 25/9/16.
 */
public class GotCharacterImageService {

    public interface GotCharacterImageServiceListener {
        void onImageRetrieved(Bitmap bitmap);
        void onError();
    }

    public void getCharacterImage(String imageUrl, final GotCharacterImageServiceListener listener) {
        new ImageFactory().getImage(imageUrl, new ImageFactory.ImageFactoryListener() {
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
