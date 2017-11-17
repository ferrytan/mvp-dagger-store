package com.meetferrytan.mvpdaggerstore.presentation.example.childfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meetferrytan.mvpdaggerstore.R;
import com.meetferrytan.mvpdaggerstore.presentation.base.BaseMvpFragment;

import dagger.android.support.AndroidSupportInjection;

public class ExampleChildFragment extends BaseMvpFragment<ExampleChildFragmentPresenter, ExampleChildFragmentContract.View>
        implements ExampleChildFragmentContract.View {
    public ExampleChildFragment() {
        // Required empty public constructor
    }

    public static ExampleChildFragment newInstance() {
        ExampleChildFragment fragment = new ExampleChildFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void inject() {
        AndroidSupportInjection.inject(this);
    }

    @Override
    protected View createLayout(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.child_fragment_example, container, false);
    }

    @Override
    public void processArguments(Bundle args) {

    }

    @Override
    public void startingUpFragment(View view, Bundle savedInstanceState) {

    }

    @Override
    public ExampleChildFragmentContract.View getViewImpl() {
        return this;
    }

    @Override
    public void showError(int processCode, int errorCode, String message) {

    }

    @Override
    public void showLoading(int processCode, boolean show) {

    }
}
