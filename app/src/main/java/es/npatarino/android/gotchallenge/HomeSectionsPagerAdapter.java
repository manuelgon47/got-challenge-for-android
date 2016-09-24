package es.npatarino.android.gotchallenge;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import es.npatarino.android.gotchallenge.characters.GoTListFragment;
import es.npatarino.android.gotchallenge.houses.GoTHousesListFragment;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class HomeSectionsPagerAdapter extends FragmentPagerAdapter {

    public HomeSectionsPagerAdapter(FragmentManager fm) {
        super(fm);
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

                return "Characters";

            case 1:

                return "Houses";
        }

        return null;
    }
}
