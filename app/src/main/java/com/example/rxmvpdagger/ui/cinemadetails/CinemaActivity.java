
package com.example.rxmvpdagger.ui.cinemadetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.rxmvpdagger.R;
import com.example.rxmvpdagger.base.BaseActivity;
import com.example.rxmvpdagger.models.ListCinema;

import butterknife.BindView;

public class CinemaActivity extends BaseActivity {
    public static final String CINEMA = "cinema";

    @BindView(R.id.image_cinema)
    ImageView imageCinema;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.description)
    TextView description;


    public static void startActivity(Context context, ListCinema.Cinema cinema) {
        Intent intent = new Intent(context, CinemaActivity.class);
        intent.putExtra(CINEMA, cinema);
        context.startActivity(intent);

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_cinema;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ListCinema.Cinema cinema = getIntent().getParcelableExtra(CINEMA);

        Glide.with(this)
                .load(cinema.getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageCinema);
        name.setText(cinema.getName());
        description.setText(cinema.getDescription());
        date.setText(cinema.getPremiere());

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


}
