package com.example.rxmvpdagger.injection;

import com.example.rxmvpdagger.ArchApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Dmitry on 12/13/2017
 */

@Component(modules = {AppModule.class, AndroidSupportInjectionModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<ArchApp> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<ArchApp> {
    }

}
