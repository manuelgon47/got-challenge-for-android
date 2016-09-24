package es.npatarino.android.gotchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private HomeToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = new HomeToolbar(this);

        initHomeViewPager();
    }

    private HomeViewPager initHomeViewPager() {

        return new HomeViewPager(this);
    }

}
