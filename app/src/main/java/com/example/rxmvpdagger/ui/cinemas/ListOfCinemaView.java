package com.example.rxmvpdagger.ui.cinemas;

import com.example.rxmvpdagger.base.BaseView;
import com.example.rxmvpdagger.models.ListCinema;

import java.util.List;

/**
 * Created by Dmitry on 12/21/2017
 */

public interface ListOfCinemaView extends BaseView {

    void showCinema(List<ListCinema.Cinema> items);

    void showError(String message);

}
