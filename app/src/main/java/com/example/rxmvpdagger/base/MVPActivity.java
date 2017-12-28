package com.example.rxmvpdagger.base;

import android.os.Bundle;

/**
 * Created by Dmitry on 12/12/2017
 */
public abstract class MVPActivity<PRESENTER extends BasePresenter, VIEW extends BaseView> extends BaseActivity {
    PRESENTER presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = getPresenter();
        if (presenter != null) {
            presenter.setView(getView());
            presenter.onCreate();
        }
    }


    @Override
    public void onStart() {
        super.onStart();

        if (presenter != null)
            presenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

        if (presenter != null)
            presenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.onDestroy();

    }



    protected abstract PRESENTER getPresenter();

    protected abstract VIEW getView();
}
