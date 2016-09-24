package es.npatarino.android.gotchallenge.characters;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

import es.npatarino.android.gotchallenge.dtos.CharacterDto;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class GoTAdapterFilter extends Filter {

    private SearchableGoTAdapter searchableGoTAdapter;

    public GoTAdapterFilter(SearchableGoTAdapter searchableGoTAdapter) {
        this.searchableGoTAdapter = searchableGoTAdapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        final FilterResults newFilterResults = new FilterResults();
        final List<CharacterDto> results = new ArrayList<>();
        if (searchableGoTAdapter.getBackup() == null) {
            searchableGoTAdapter.setBackup(searchableGoTAdapter.getGcs());
        }

        if (constraint != null) {

            if (searchableGoTAdapter.getBackup() != null && searchableGoTAdapter.getBackup().size() > 0) {
                for (final CharacterDto g : searchableGoTAdapter.getBackup()) {
                    if (g.getN().toLowerCase().contains(constraint.toString())) {
                        results.add(g);
                    }
                }
            }

            newFilterResults.values = results;
        }

        return newFilterResults;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        searchableGoTAdapter.setGcs((ArrayList<CharacterDto>) results.values);
        searchableGoTAdapter.notifyDataSetChanged();
    }
}
