package com.meetferrytan.mvpdaggerstore.presentation.example.fragment;

import com.meetferrytan.mvpdaggerstore.presentation.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by ferrytan on 11/8/17.
 */

public class ExampleFragmentPresenter extends BasePresenter<ExampleFragmentContract.View>
        implements ExampleFragmentContract.Presenter {

    @Inject
    public ExampleFragmentPresenter() {
    }
}
