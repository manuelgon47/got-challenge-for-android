package es.npatarino.android.gotchallenge.webservice;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

import es.npatarino.android.gotchallenge.utils.Constants;

/**
 * Created by Manuel González Villegas on 25/9/16.
 */
public class GotImageAssetsClient implements IGotImageClient {

    private IGotImageListener listener;
    private Activity activity;

    public GotImageAssetsClient(Activity activity, IGotImageListener listener) {
        this.listener = listener;
        this.activity = activity;
    }

    @Override
    public void getImageBitmap(final String imageUrl) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    InputStream is = activity.getAssets().open(imageUrl);
                    Bitmap bmp = BitmapFactory.decodeStream(is);

                    listener.onImageRetrieved(bmp);
                } catch (IOException e) {
                    Log.e(Constants.TAG_DEBUG, "Error reading image file", e);
                    listener.onError();
                }
            }
        }).start();
    }
}
