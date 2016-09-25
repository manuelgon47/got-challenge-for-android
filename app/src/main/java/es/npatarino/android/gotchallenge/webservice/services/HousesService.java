package es.npatarino.android.gotchallenge.webservice.services;

import android.app.Activity;
import android.support.v4.widget.ContentLoadingProgressBar;

import java.util.List;

import es.npatarino.android.gotchallenge.dtos.HouseDto;
import es.npatarino.android.gotchallenge.houses.GoTHouseAdapter;
import es.npatarino.android.gotchallenge.webservice.clients.houses.HousesClient;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class HousesService {

    private Activity activity;

    /**
     * This service will retrieve the characters from server and will load it on the view.
     *
     * @param activity
     */
    public HousesService(Activity activity) {
       this.activity = activity;
    }

    public void getHouses(final GoTHouseAdapter adapter, final ContentLoadingProgressBar progressBar) {
        new HousesClient(activity).getHouses(new HousesClient.GetHousesListener() {
            @Override
            public void onResponseOk(List<HouseDto> houses) {
                responseOk(houses, adapter, progressBar);
            }

            @Override
            public void onError() {
                progressBar.hide();
            }
        });
    }

    private void responseOk(final List<HouseDto> houses, final GoTHouseAdapter adapter, final ContentLoadingProgressBar progressBar) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.addAll(houses);
                adapter.notifyDataSetChanged();
                progressBar.hide();
            }
        });
    }
}
