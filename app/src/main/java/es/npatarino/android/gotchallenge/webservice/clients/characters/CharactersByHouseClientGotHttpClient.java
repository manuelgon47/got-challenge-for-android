package es.npatarino.android.gotchallenge.webservice.clients.characters;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import es.npatarino.android.gotchallenge.dtos.CharacterDto;
import es.npatarino.android.gotchallenge.utils.Constants;
import es.npatarino.android.gotchallenge.webservice.IGotClientListener;
import es.npatarino.android.gotchallenge.webservice.parsers.CharacterDtoJsonParser;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class CharactersByHouseClientGotHttpClient implements IGotClientListener {

    private CharactersClient.GetCharactersListener listener;
    private String houseId;

    public CharactersByHouseClientGotHttpClient(String houseId, CharactersClient.GetCharactersListener listener) {
        this.listener = listener;
        this.houseId = houseId;
    }

    @Override
    public void responseOk(String response) {
        try {
            JSONArray jsonArray = parseCharacters(response);
            List<CharacterDto> characters = parseCharactersJson(jsonArray);
            listener.onResponseOk(characters);
        } catch (JSONException je) {
            Log.e(Constants.TAG_DEBUG, "Error parsing the Characters json", e);
            listener.onError();
        }
    }

    @Override
    public void responseError() {
        listener.onError();
    }

    private JSONArray parseCharacters(String response) throws JSONException {

        return new JSONArray(response);
    }

    private List<CharacterDto> parseCharactersJson(JSONArray jsonArray) {
        List<CharacterDto> characters = new ArrayList<>();
        if (jsonArray.length() > 0) {

            CharacterDtoJsonParser parser = new CharacterDtoJsonParser();
            for (int i = 0; i < jsonArray.length(); i++) {
                CharacterDto character = parser.parse(jsonArray.optJSONObject(i));

                if (houseId.equals(character.getHi())) {
                    characters.add(character);
                }
            }
        }

        return characters;
    }

}
