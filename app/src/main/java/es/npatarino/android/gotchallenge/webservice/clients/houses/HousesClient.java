package es.npatarino.android.gotchallenge.webservice.clients.houses;

import android.app.Activity;

import java.util.List;

import es.npatarino.android.gotchallenge.dtos.HouseDto;
import es.npatarino.android.gotchallenge.webservice.GotClientFactory;
import es.npatarino.android.gotchallenge.webservice.IGotClientListener;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class HousesClient {

    private static final String GET_HOUSES = "characters.json?print=pretty";

    private Activity activity;

    public HousesClient(Activity activity) {
        this.activity = activity;
    }

    public interface GetHousesListener {
        void onResponseOk(List<HouseDto> houses);
        void onError();
    }

    public void getHouses(GetHousesListener listener) {
        IGotClientListener httpListener = new HousesClientHttpClient(listener);

        GotClientFactory.getClient(activity, httpListener).get(GET_HOUSES);
    }
}
