package com.example.rxmvpdagger.base;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Dmitry on 12/12/2017
 */

public abstract class BaseActivity  extends DaggerAppCompatActivity {

    Unbinder unbind;

    protected abstract int getContentView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        unbind = ButterKnife.bind(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbind.unbind();

    }


}