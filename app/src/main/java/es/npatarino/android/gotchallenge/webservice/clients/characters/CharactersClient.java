package es.npatarino.android.gotchallenge.webservice.clients.characters;

import java.util.List;

import es.npatarino.android.gotchallenge.dtos.CharacterDto;
import es.npatarino.android.gotchallenge.webservice.GotClientFactory;
import es.npatarino.android.gotchallenge.webservice.IGotClientListener;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class CharactersClient {

    private static final String GET_CHARACTERS = "characters.json?print=pretty";

    public interface GetCharactersListener {

        /**
         * Response from server is Ok.
         *
         * @param characters The characters
         */
        void onResponseOk(List<CharacterDto> characters);

        /**
         * Error retrieving the characters
         */
        void onError();
    }

    public void getCharacters(GetCharactersListener listener) {
        IGotClientListener httpListener = new CharactersClientGotHttpClient(listener);

        GotClientFactory.getClient(httpListener).get(GET_CHARACTERS);
    }

    public void getCharactersByHouse(String houseId, GetCharactersListener listener) {
        IGotClientListener httpListener = new CharactersByHouseClientGotHttpClient(houseId, listener);

        GotClientFactory.getClient(httpListener).get(GET_CHARACTERS);
    }

}
