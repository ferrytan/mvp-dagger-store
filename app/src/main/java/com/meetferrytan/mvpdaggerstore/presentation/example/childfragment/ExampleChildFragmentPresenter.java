package com.meetferrytan.mvpdaggerstore.presentation.example.childfragment;


import com.meetferrytan.mvpdaggerstore.presentation.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by ferrytan on 11/8/17.
 */

public class ExampleChildFragmentPresenter extends BasePresenter<ExampleChildFragmentContract.View>
        implements ExampleChildFragmentContract.Presenter {

    @Inject
    public ExampleChildFragmentPresenter() {
    }
}
