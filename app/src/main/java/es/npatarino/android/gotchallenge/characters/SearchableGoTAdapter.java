package es.npatarino.android.gotchallenge.characters;

import android.app.Activity;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.List;

import es.npatarino.android.gotchallenge.dtos.CharacterDto;

/**
 * Created by Manuel González Villegas on 22/9/16.
 */
public class SearchableGoTAdapter extends GoTAdapter implements Filterable {

    private List<CharacterDto> backup;

    public SearchableGoTAdapter(Activity activity) {
        super(activity);
    }

    public List<CharacterDto> getBackup() {
        return backup;
    }

    public void setBackup(List<CharacterDto> backup) {
        this.backup = backup;
    }

    @Override
    public Filter getFilter() {
        return new GoTAdapterFilter(this);
    }
}
