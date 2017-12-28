package com.example.rxmvpdagger.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Dmitry on 12/12/2017
 */

public class BasePresenter<V extends BaseView> {
    private V view;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void setView(V view) {
        this.view = view;
    }

    protected void onCreate() {
    }

    protected void onStart() {
    }

    protected void onStop() {
    }

    protected void onDestroy() {
        compositeDisposable.clear();
    }

    protected void withDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);

    }

    protected V getView() {
        return view;
    }

}
