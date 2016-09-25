package es.npatarino.android.gotchallenge.characters.partials;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import es.npatarino.android.gotchallenge.R;
import es.npatarino.android.gotchallenge.dtos.CharacterDto;
import es.npatarino.android.gotchallenge.webservice.services.GotCharacterImageService;

/**
 * Created by Manuel González Villegas on 23/9/16.
 */
public class GotCharacterViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "GotCharacterViewHolder";
    ImageView imp;
    TextView tvn;
    Activity activity;

    public GotCharacterViewHolder(View itemView, Activity activity) {
        super(itemView);
        imp = (ImageView) itemView.findViewById(R.id.ivBackground);
        tvn = (TextView) itemView.findViewById(R.id.tv_name);
        this.activity = activity;
    }

    public void render(final CharacterDto goTCharacter) {
        new GotCharacterImageService().getCharacterImage(goTCharacter.getIu(), new GotCharacterImageService.GotCharacterImageServiceListener() {
            @Override
            public void onImageRetrieved(final Bitmap bitmap) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imp.setImageBitmap(bitmap);
                        tvn.setText(goTCharacter.getN());
                    }
                });
            }

            @Override
            public void onError() {
                // Do nothing here. May be it sould display a toast message
            }
        });
    }

    // **********************************
    // *        Getters/Setters         *
    // **********************************

    public ImageView getImp() {
        return imp;
    }

    public TextView getTvn() {
        return tvn;
    }
}
