package es.npatarino.android.gotchallenge.houses.partials;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import es.npatarino.android.gotchallenge.R;
import es.npatarino.android.gotchallenge.dtos.HouseDto;
import es.npatarino.android.gotchallenge.webservice.services.GotHouseImageService;

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
        new GotHouseImageService().getHouseImage(goTHouse.getHu(), new GotHouseImageService.GotHouseImageServiceListener() {
            @Override
            public void onImageRetrieved(final Bitmap bitmap) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imp.setImageBitmap(bitmap);
                    }
                });
            }

            @Override
            public void onError() {
                // Do nothing here. May be it sould display a toast message
            }
        });
    }

    public ImageView getImp() {
        return imp;
    }
}
