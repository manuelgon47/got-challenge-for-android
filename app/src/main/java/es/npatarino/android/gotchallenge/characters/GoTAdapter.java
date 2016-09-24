package es.npatarino.android.gotchallenge.characters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import es.npatarino.android.gotchallenge.DetailActivity;
import es.npatarino.android.gotchallenge.R;
import es.npatarino.android.gotchallenge.characters.partials.GotCharacterViewHolder;
import es.npatarino.android.gotchallenge.dtos.CharacterDto;

/**
 * Created by Manuel González Villegas on 22/9/16.
 */
public class GoTAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CharacterDto> gcs;
    private Activity a;

    public GoTAdapter(Activity activity) {
        this.gcs = new ArrayList<>();
        a = activity;
    }

    public void addAll(Collection<CharacterDto> collection) {
        for (int i = 0; i < collection.size(); i++) {
            gcs.add((CharacterDto) collection.toArray()[i]);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View gotCharacterView = LayoutInflater.from(parent.getContext()).inflate(R.layout.got_character_row, parent, false);
        return new GotCharacterViewHolder(gotCharacterView, a);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        GotCharacterViewHolder gotCharacterViewHolder = (GotCharacterViewHolder) holder;
        gotCharacterViewHolder.render(gcs.get(position));
        ((GotCharacterViewHolder) holder).getImp().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(((GotCharacterViewHolder) holder).itemView.getContext(), DetailActivity.class);
                intent.putExtra("description", gcs.get(position).getD());
                intent.putExtra("name", gcs.get(position).getN());
                intent.putExtra("imageUrl", gcs.get(position).getIu());
                ((GotCharacterViewHolder) holder).itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gcs.size();
    }

    public void setGcs(List<CharacterDto> gcs) {
        this.gcs = gcs;
    }

    public List<CharacterDto> getGcs() {
        return gcs;
    }
}
