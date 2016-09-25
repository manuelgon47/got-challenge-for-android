package es.npatarino.android.gotchallenge.webservice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.net.URL;

import es.npatarino.android.gotchallenge.utils.Constants;

/**
 * Created by Manuel González Villegas on 25/9/16.
 */
public class GotImageHttpClient {

    private IGotImageHttpListener listener;

    public GotImageHttpClient(IGotImageHttpListener listener) {
        this.listener = listener;
    }

    public void getImageBitmap(final String imageUrl) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                try {
                    url = new URL(imageUrl);
                    final Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    listener.onImageRetrieved(bmp);
                } catch (Exception e) {
                    Log.e(Constants.TAG_DEBUG, "Error decoding bitmap image from url (" + imageUrl + ")", e);
                    listener.onError();
                }
            }
        }).start();
    }
}
