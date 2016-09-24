package es.npatarino.android.gotchallenge.webservice.clients.characters;

import java.util.List;

import es.npatarino.android.gotchallenge.dtos.CharacterDto;
import es.npatarino.android.gotchallenge.webservice.GotHttpClient;
import es.npatarino.android.gotchallenge.webservice.IGotHttpListener;

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
        IGotHttpListener httpListener = new CharactersClientGotHttpClient(listener);

        new GotHttpClient(httpListener).get(GET_CHARACTERS);
    }

}
