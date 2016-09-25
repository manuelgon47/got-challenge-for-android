package es.npatarino.android.gotchallenge.webservice.services;

import android.graphics.Bitmap;

import es.npatarino.android.gotchallenge.utils.ImageFactory;

/**
 * Created by Manuel González Villegas on 25/9/16.
 */
public class GotHouseImageService {

    public interface GotHouseImageServiceListener {
        void onImageRetrieved(Bitmap bitmap);
        void onError();
    }

    public void getHouseImage(String imageUrl, final GotHouseImageServiceListener listener) {
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
