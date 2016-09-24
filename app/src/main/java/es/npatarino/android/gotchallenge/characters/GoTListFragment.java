package es.npatarino.android.gotchallenge.characters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.npatarino.android.gotchallenge.R;
import es.npatarino.android.gotchallenge.webservice.services.CharactersService;

/**
 * Created by Manuel González Villegas on 22/9/16.
 */
public class GoTListFragment extends Fragment {

    private static final String TAG = "GoTListFragment";

    public GoTListFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        final ContentLoadingProgressBar pb = (ContentLoadingProgressBar) rootView.findViewById(R.id.pb);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv);

        final GoTAdapter adp = new GoTAdapter(getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setHasFixedSize(true);
        rv.setAdapter(adp);

        new CharactersService(getActivity()).getCharacters(adp, pb);

        return rootView;
    }
}
