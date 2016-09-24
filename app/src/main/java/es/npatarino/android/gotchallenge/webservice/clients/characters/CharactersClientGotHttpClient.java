package es.npatarino.android.gotchallenge.webservice.clients.characters;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import es.npatarino.android.gotchallenge.webservice.parsers.CharacterDtoJsonParser;
import es.npatarino.android.gotchallenge.dtos.CharacterDto;
import es.npatarino.android.gotchallenge.utils.Constants;
import es.npatarino.android.gotchallenge.webservice.IGotHttpListener;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class CharactersClientGotHttpClient implements IGotHttpListener {

    private CharactersClient.GetCharactersListener listener;

    public CharactersClientGotHttpClient(CharactersClient.GetCharactersListener listener) {
        this.listener = listener;
    }

    @Override
    public void responseOk(StringBuffer response) {
        try {
            JSONArray jsonArray = parseCharacters(response);
            List<CharacterDto> characters = parseCharactersJson(jsonArray);
            listener.onResponseOk(characters);
        } catch (JSONException je) {
            Log.e(Constants.TAG_DEBUG, "Error parsing the Characters json");
            listener.onError();
        }
    }

    @Override
    public void responseError() {
        listener.onError();
    }

    private JSONArray parseCharacters(StringBuffer response) throws JSONException {

        return new JSONArray(response.toString());
    }

    private List<CharacterDto> parseCharactersJson(JSONArray jsonArray) {
        List<CharacterDto> characters = new ArrayList<>();
        if (jsonArray.length() > 0) {

            CharacterDtoJsonParser parser = new CharacterDtoJsonParser();
            for (int i = 0; i < jsonArray.length(); i++) {
                CharacterDto character = parser.parse(jsonArray.optJSONObject(i));

                characters.add(character);
            }
        }

        return characters;
    }

}
