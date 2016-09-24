package es.npatarino.android.gotchallenge.characters.partials;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

import es.npatarino.android.gotchallenge.R;
import es.npatarino.android.gotchallenge.dtos.CharacterDto;

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
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                try {
                    url = new URL(goTCharacter.getIu());
                    final Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imp.setImageBitmap(bmp);
                            tvn.setText(goTCharacter.getN());
                        }
                    });
                } catch (IOException e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }
            }
        }).start();
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
