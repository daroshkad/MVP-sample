package com.example.rxmvpdagger.injection;

import android.content.Context;

import com.example.rxmvpdagger.ArchApp;
import com.example.rxmvpdagger.api.Api;
import com.example.rxmvpdagger.ui.cinemadetails.CinemaActivity;
import com.example.rxmvpdagger.ui.cinemas.ListOfCinemaActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Dmitry on 12/13/2017
 */

@Module
public abstract class AppModule {

    @Singleton
    @Provides
    public static Context provideContext() {
        return ArchApp.getContext();

    }

    @Singleton
    @Provides
    public static Api provideAPI(Context context) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        clientBuilder.addInterceptor(loggingInterceptor);

        return new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .client(clientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(Api.class);

    }

    @ContributesAndroidInjector
    abstract ListOfCinemaActivity componentListOfCinemaInjector();

    @ContributesAndroidInjector
    abstract CinemaActivity componentCinemaInjector();

}
