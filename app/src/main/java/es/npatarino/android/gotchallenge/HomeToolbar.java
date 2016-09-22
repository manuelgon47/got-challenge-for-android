package es.npatarino.android.gotchallenge;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import es.npatarino.android.gotchallenge.utils.Constants;

/**
 * Created by Manuel González Villegas on 22/9/16.
 */
public class HomeToolbar {

    private HomeActivity homeActivity;

    public HomeToolbar(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;

        Toolbar toolbar = (Toolbar) homeActivity.findViewById(R.id.toolbar);
        homeActivity.setSupportActionBar(toolbar);

        ActionBar actionBar = homeActivity.getSupportActionBar();
        if (actionBar == null) {
            Log.e(Constants.TAG_DEBUG, "ActionBar is null because HomeActivity does not have one");

            return;
        }

    }
}
