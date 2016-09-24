package es.npatarino.android.gotchallenge;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    SectionsPagerAdapter spa;
    ViewPager vp;
    private HomeToolbar toolbar;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = new HomeToolbar(this);
        setSpa(new SectionsPagerAdapter(getSupportFragmentManager()));

        setVp((ViewPager) findViewById(R.id.container));
        getVp().setAdapter(getSpa());

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(getVp());
    }

    public SectionsPagerAdapter getSpa() {
        return spa;
    }

    public void setSpa(SectionsPagerAdapter spa) {
        this.spa = spa;
    }

    public ViewPager getVp() {
        return vp;
    }

    public void setVp(ViewPager vp) {
        this.vp = vp;
    }

}
