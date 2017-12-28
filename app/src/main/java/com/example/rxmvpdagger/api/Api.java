package com.example.rxmvpdagger.api;


import com.example.rxmvpdagger.models.ListCinema;

import io.reactivex.Flowable;
import retrofit2.http.GET;


public interface Api {

    @GET("v2/57cffac8260000181e650041")
    Flowable<ListCinema> getListCinema();
}
