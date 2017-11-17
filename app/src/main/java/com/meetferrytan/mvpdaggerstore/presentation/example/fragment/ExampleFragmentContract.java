package com.meetferrytan.mvpdaggerstore.presentation.example.fragment;


import com.meetferrytan.mvpdaggerstore.presentation.base.BaseContract;

/**
 * Created by ferrytan on 11/8/17.
 */

public class ExampleFragmentContract {

    interface View extends BaseContract.View {

    }

    interface Presenter extends BaseContract.Presenter<ExampleFragmentContract.View> {

    }
}
