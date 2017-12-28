package com.example.rxmvpdagger;

import android.content.Context;

import com.example.rxmvpdagger.injection.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by Dmitry on 04/18/2016
 */
public class ArchApp extends DaggerApplication {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

    public static Context getContext() {
        return context;
    }
}
