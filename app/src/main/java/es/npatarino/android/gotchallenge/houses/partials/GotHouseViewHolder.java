package es.npatarino.android.gotchallenge.houses.partials;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;

import es.npatarino.android.gotchallenge.R;
import es.npatarino.android.gotchallenge.dtos.HouseDto;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class GotHouseViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "GotCharacterViewHolder";
    ImageView imp;
    private Activity activity;

    public GotHouseViewHolder(View itemView, Activity activity) {
        super(itemView);
        this.activity = activity;
        imp = (ImageView) itemView.findViewById(R.id.ivBackground);
    }

    public void render(final HouseDto goTHouse) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                try {
                    url = new URL(goTHouse.getHu());
                    final Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imp.setImageBitmap(bmp);
                        }
                    });
                } catch (IOException e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }
            }
        }).start();
    }

    public ImageView getImp() {
        return imp;
    }
}
