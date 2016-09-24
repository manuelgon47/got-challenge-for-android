package es.npatarino.android.gotchallenge.webservice.clients.houses;

import java.util.List;

import es.npatarino.android.gotchallenge.dtos.HouseDto;
import es.npatarino.android.gotchallenge.webservice.GotHttpClient;
import es.npatarino.android.gotchallenge.webservice.IGotHttpListener;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class HousesClient {

    private static final String GET_HOUSES = "characters.json?print=pretty";

    public interface GetHousesListener {
        void onResponseOk(List<HouseDto> houses);
        void onError();
    }

    public void getHouses(GetHousesListener listener) {
        IGotHttpListener httpListener = new HousesClientHttpClient(listener);

        new GotHttpClient(httpListener).get(GET_HOUSES);
    }
}
