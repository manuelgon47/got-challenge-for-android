package es.npatarino.android.gotchallenge.webservice.parsers;

import org.json.JSONObject;

import es.npatarino.android.gotchallenge.dtos.CharacterDto;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class CharacterDtoJsonParser {

    public CharacterDto parse(JSONObject json) {
        CharacterDto character = new CharacterDto();
        character.setN(json.optString("name", ""));
        character.setIu(json.optString("imageUrl", ""));
        character.setHi(json.optString("houseId", ""));
        character.setD(json.optString("description", ""));

        return character;
    }
}
