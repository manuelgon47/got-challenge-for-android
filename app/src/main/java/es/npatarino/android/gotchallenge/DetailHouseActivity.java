package es.npatarino.android.gotchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class DetailHouseActivity extends AppCompatActivity {

    public static final String PARAM_HOUSE_ID = "houseId";
    public static final String PARAM_HOUSE_NAME = "houseName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_detail);

        String houseId = getIntent().getStringExtra(PARAM_HOUSE_ID);
        String houseName = getIntent().getStringExtra(PARAM_HOUSE_NAME);

        new DetailHouseToolbar(this, houseName);

    }

    // ******************************
    // *        Action Bar          *
    // ******************************
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
