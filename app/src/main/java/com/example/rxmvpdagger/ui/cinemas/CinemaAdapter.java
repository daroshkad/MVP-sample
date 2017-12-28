package com.example.rxmvpdagger.ui.cinemas;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.rxmvpdagger.R;
import com.example.rxmvpdagger.models.ListCinema;

import java.util.ArrayList;
import java.util.List;


public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.ItemViewHolder> {
    private List<ListCinema.Cinema> items;
    private CallBack callBack;

    public ListCinema.Cinema getItem(int position) {
        return items.get(position);
    }

    public CinemaAdapter(CallBack callBack) {
        items = new ArrayList<>();
        this.callBack = callBack;
    }


    public void setItems(List<ListCinema.Cinema> items) {
        this.items = items;
        notifyDataSetChanged();

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cinema, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {

        Glide.with(holder.itemView.getContext())
                .load(getItem(position).getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageCinema);

        holder.name.setText(getItem(position).getNameEng());
        holder.cw.setOnClickListener(view -> callBack.onClickItem(holder.getAdapterPosition(), items.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageCinema;
        TextView name;
        CardView cw;

        ItemViewHolder(View v) {
            super(v);
            imageCinema = v.findViewById(R.id.image_cinema);
            name = v.findViewById(R.id.name);
            cw = v.findViewById(R.id.card_view);
        }
    }

    public interface CallBack {
        void onClickItem(int position, ListCinema.Cinema cinemaItem);
    }
}
