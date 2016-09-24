package es.npatarino.android.gotchallenge.characters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.npatarino.android.gotchallenge.R;
import es.npatarino.android.gotchallenge.webservice.services.CharactersService;

/**
 * Created by Manuel González Villegas on 22/9/16.
 */
public class GoTListFragment extends Fragment implements SearchView.OnQueryTextListener {

    private static final String TAG = "GoTListFragment";

    private SearchableGoTAdapter adp;

    public GoTListFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        final ContentLoadingProgressBar pb = (ContentLoadingProgressBar) rootView.findViewById(R.id.pb);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv);

        adp = new SearchableGoTAdapter(getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setHasFixedSize(true);
        rv.setAdapter(adp);

        SearchView searchView = (SearchView) rootView.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);

        new CharactersService(getActivity()).getCharacters(adp, pb);

        return rootView;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            adp.getFilter().filter("");
        }

        adp.getFilter().filter(newText.toString());

        return true;
    }
}
