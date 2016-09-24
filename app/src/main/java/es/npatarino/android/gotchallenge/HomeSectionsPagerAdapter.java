package es.npatarino.android.gotchallenge;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import es.npatarino.android.gotchallenge.characters.GoTListFragment;
import es.npatarino.android.gotchallenge.houses.GoTHousesListFragment;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class HomeSectionsPagerAdapter extends FragmentPagerAdapter {

    private HomeActivity homeActivity;
    public HomeSectionsPagerAdapter(HomeActivity activity) {
        super(activity.getSupportFragmentManager());

        this.homeActivity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {

            return new GoTListFragment();
        }

        return new GoTHousesListFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:

                return homeActivity.getString(R.string.home_section_pager_characters);

            case 1:

                return homeActivity.getString(R.string.home_section_pager_houses);
        }

        return null;
    }
}
