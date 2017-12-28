package com.example.rxmvpdagger.ui.cinemas;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.rxmvpdagger.R;
import com.example.rxmvpdagger.base.MVPActivity;
import com.example.rxmvpdagger.models.ListCinema;
import com.example.rxmvpdagger.ui.cinemadetails.CinemaActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


public class ListOfCinemaActivity extends MVPActivity<ListOfCinemaPresenter, ListOfCinemaView> implements ListOfCinemaView {
    @BindView(R.id.recycler_cinema)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    View progressBar;

    @Inject
    ListOfCinemaPresenter presenter;

    CinemaAdapter cinemaAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public ListOfCinemaPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected ListOfCinemaView getView() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        cinemaAdapter = new CinemaAdapter((position, cinema) -> CinemaActivity.startActivity(ListOfCinemaActivity.this, cinema));
        recyclerView.setAdapter(cinemaAdapter);

    }


    @Override
    public void showCinema(List<ListCinema.Cinema> items) {
        cinemaAdapter.setItems(items);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        //handle error here
    }
}
