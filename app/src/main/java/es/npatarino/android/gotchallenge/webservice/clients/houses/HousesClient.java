package es.npatarino.android.gotchallenge.webservice.clients.houses;

import java.util.List;

import es.npatarino.android.gotchallenge.dtos.HouseDto;
import es.npatarino.android.gotchallenge.webservice.GotClientFactory;
import es.npatarino.android.gotchallenge.webservice.IGotClientListener;

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
        IGotClientListener httpListener = new HousesClientHttpClient(listener);

        GotClientFactory.getClient(httpListener).get(GET_HOUSES);
    }
}
