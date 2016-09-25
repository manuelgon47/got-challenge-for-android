package es.npatarino.android.gotchallenge.webservice.services;

import android.app.Activity;
import android.support.v4.widget.ContentLoadingProgressBar;

import java.util.List;

import es.npatarino.android.gotchallenge.characters.GoTAdapter;
import es.npatarino.android.gotchallenge.dtos.CharacterDto;
import es.npatarino.android.gotchallenge.webservice.clients.characters.CharactersClient;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class CharactersService {

    private Activity activity;

    /**
     * This service will retrieve the characters from server and will load it on the view.
     *
     * @param activity
     */
    public CharactersService(Activity activity) {
        this.activity = activity;
    }

    public void getCharacters(final GoTAdapter adapter, final ContentLoadingProgressBar progressBar) {

        new CharactersClient(activity).getCharacters(new CharactersClient.GetCharactersListener() {
            @Override
            public void onResponseOk(List<CharacterDto> characters) {
                responseOk(characters, adapter, progressBar);
            }

            @Override
            public void onError() {
                progressBar.hide();
            }
        });
    }

    public void getCharactersByHouse(
            final String houseId,
            final GoTAdapter adapter,
            final ContentLoadingProgressBar progressBar) {
        new CharactersClient(activity).getCharactersByHouse(houseId, new CharactersClient.GetCharactersListener() {
            @Override
            public void onResponseOk(List<CharacterDto> characters) {
                responseOk(characters, adapter, progressBar);
            }

            @Override
            public void onError() {
                progressBar.hide();
            }
        });
    }

    private void responseOk(final List<CharacterDto> characters, final GoTAdapter adapter, final ContentLoadingProgressBar progressBar) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.addAll(characters);
                adapter.notifyDataSetChanged();
                progressBar.hide();
            }
        });
    }
}
