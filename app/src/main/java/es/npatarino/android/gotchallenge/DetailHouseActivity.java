package es.npatarino.android.gotchallenge;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.MenuItem;

import es.npatarino.android.gotchallenge.characters.SearchableGoTAdapter;
import es.npatarino.android.gotchallenge.webservice.services.CharactersService;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class DetailHouseActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    public static final String PARAM_HOUSE_ID = "houseId";
    public static final String PARAM_HOUSE_NAME = "houseName";

    private SearchableGoTAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_detail);

        String houseId = getIntent().getStringExtra(PARAM_HOUSE_ID);
        String houseName = getIntent().getStringExtra(PARAM_HOUSE_NAME);

        new DetailHouseToolbar(this, houseName);

        final ContentLoadingProgressBar pb = (ContentLoadingProgressBar) findViewById(R.id.pb);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);

        adp = new SearchableGoTAdapter(this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        rv.setAdapter(adp);

        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);

        new CharactersService(this).getCharactersByHouse(houseId, adp, pb);

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

    // **************************
    // *        Filter          *
    // **************************
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            adp.getFilter().filter("");
        }

        adp.getFilter().filter(newText.toString());

        return true;
    }

}
