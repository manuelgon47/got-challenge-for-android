package es.npatarino.android.gotchallenge.webservice.clients.houses;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.npatarino.android.gotchallenge.dtos.HouseDto;
import es.npatarino.android.gotchallenge.utils.Constants;
import es.npatarino.android.gotchallenge.webservice.IGotClientListener;
import es.npatarino.android.gotchallenge.webservice.parsers.HouseDtoJsonParser;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class HousesClientHttpClient implements IGotClientListener {

    private HousesClient.GetHousesListener listener;

    public HousesClientHttpClient(HousesClient.GetHousesListener listener) {
        this.listener = listener;
    }

    @Override
    public void responseOk(String response) {
        try {
            JSONArray jsonArray = parseHouses(response);
            List<HouseDto> characters = parseHousesJson(jsonArray);
            listener.onResponseOk(characters);
        } catch (JSONException je) {
            Log.e(Constants.TAG_DEBUG, "Error parsing the Houses json");
            listener.onError();
        }
    }

    @Override
    public void responseError() {
        listener.onError();
    }

    private JSONArray parseHouses(String response) throws JSONException {

        return new JSONArray(response);
    }

    private List<HouseDto> parseHousesJson(JSONArray jsonArray) {
        List<HouseDto> houses = new ArrayList<>();
        if (jsonArray.length() > 0) {

            HouseDtoJsonParser parser = new HouseDtoJsonParser();
            Map<String, HouseDto> map = new HashMap<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                HouseDto house = parser.parse(jsonArray.optJSONObject(i));

                map.put(house.getHn(), house);
            }
            houses.addAll(map.values());
        }

        return houses;
    }
}
