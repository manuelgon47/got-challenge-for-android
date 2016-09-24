package es.npatarino.android.gotchallenge;

import android.support.v7.widget.Toolbar;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class DetailHouseToolbar {

    public DetailHouseToolbar(DetailHouseActivity activity, String toolbarTitle) {
        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        toolbar.setTitle(toolbarTitle);
        activity.setSupportActionBar(toolbar);
        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
