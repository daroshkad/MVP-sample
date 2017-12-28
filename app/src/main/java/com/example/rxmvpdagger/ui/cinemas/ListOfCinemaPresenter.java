package com.example.rxmvpdagger.ui.cinemas;

import com.example.rxmvpdagger.api.Api;
import com.example.rxmvpdagger.base.BasePresenter;
import com.example.rxmvpdagger.models.ListCinema;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Dmitry on 12/21/2017
 */

public class ListOfCinemaPresenter extends BasePresenter<ListOfCinemaView> {
    Api api;

    @Inject
    public ListOfCinemaPresenter(Api api) {
        this.api = api;
    }

    @Override
    protected void onCreate() {
        getCinemas();
    }

    private void getCinemas() {

        withDisposable(api.getListCinema()
                .subscribeOn(Schedulers.io())
                .map(ListCinema::getList)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response ->
                                getView().showCinema(response)
                        , throwable -> getView().showError("error fetching list")));

    }
}
