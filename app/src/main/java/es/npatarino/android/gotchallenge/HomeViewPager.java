package es.npatarino.android.gotchallenge;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class HomeViewPager {

    /**
     * Set the activity to use a ViewPager
     *
     * @param activity HomeActivity
     */
    public HomeViewPager(HomeActivity activity) {
        HomeSectionsPagerAdapter spa = getSecctionPagerAdapter(activity);

        ViewPager vp = getViewPager(activity);
        vp.setAdapter(spa);

        TabLayout tabLayout = getTabLayout(activity);
        tabLayout.setupWithViewPager(vp);

    }

    private HomeSectionsPagerAdapter getSecctionPagerAdapter(HomeActivity activity) {

        return new HomeSectionsPagerAdapter(activity);
    }

    private ViewPager getViewPager(HomeActivity activity) {

        return (ViewPager) activity.findViewById(R.id.container);
    }

    private TabLayout getTabLayout(HomeActivity activity) {

        return (TabLayout) activity.findViewById(R.id.tabs);
    }
}
