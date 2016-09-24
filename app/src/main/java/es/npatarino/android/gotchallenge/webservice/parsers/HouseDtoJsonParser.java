package es.npatarino.android.gotchallenge.webservice.parsers;

import org.json.JSONObject;

import es.npatarino.android.gotchallenge.dtos.HouseDto;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class HouseDtoJsonParser {

    public HouseDto parse(JSONObject json) {
        HouseDto house = new HouseDto();
        house.setHi(json.optString("houseId", ""));
        house.setHn(json.optString("houseName", ""));
        house.setHu(json.optString("houseImageUrl", ""));

        return house;
    }
}
