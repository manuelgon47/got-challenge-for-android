package es.npatarino.android.gotchallenge.houses;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import es.npatarino.android.gotchallenge.GoTCharacter;
import es.npatarino.android.gotchallenge.R;
import es.npatarino.android.gotchallenge.houses.partials.GotHouseViewHolder;

/**
 * Created by Manuel González Villegas on 24/9/16.
 */
public class GoTHouseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<GoTCharacter.GoTHouse> gcs;
    private Activity a;

    public GoTHouseAdapter(Activity activity) {
        this.gcs = new ArrayList<>();
        a = activity;
    }

    void addAll(Collection<GoTCharacter.GoTHouse> collection) {
        for (int i = 0; i < collection.size(); i++) {
            gcs.add((GoTCharacter.GoTHouse) collection.toArray()[i]);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View houseView = LayoutInflater.from(parent.getContext()).inflate(R.layout.got_house_row, parent, false);
        return new GotHouseViewHolder(houseView, a);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        GotHouseViewHolder gotCharacterViewHolder = (GotHouseViewHolder) holder;
        gotCharacterViewHolder.render(gcs.get(position));
    }

    @Override
    public int getItemCount() {
        return gcs.size();
    }

}
