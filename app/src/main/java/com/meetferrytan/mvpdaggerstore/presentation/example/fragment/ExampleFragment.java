package com.meetferrytan.mvpdaggerstore.presentation.example.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meetferrytan.mvpdaggerstore.R;
import com.meetferrytan.mvpdaggerstore.presentation.base.BaseMvpFragment;
import com.meetferrytan.mvpdaggerstore.presentation.example.childfragment.ExampleChildFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

public class ExampleFragment extends BaseMvpFragment<ExampleFragmentPresenter, ExampleFragmentContract.View>
        implements ExampleFragmentContract.View, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> childFragmentInjector;

    public ExampleFragment() {
        // Required empty public constructor
    }

    public static ExampleFragment newInstance() {
        ExampleFragment fragment = new ExampleFragment();
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
        return inflater.inflate(R.layout.fragment_example, container, false);
    }

    @Override
    public void processArguments(Bundle args) {

    }

    @Override
    public void startingUpFragment(View view, Bundle savedInstanceState) {
        getChildFragmentManager().beginTransaction().replace(R.id.frameLayout, ExampleChildFragment.newInstance()).commit();
    }

    @Override
    public ExampleFragmentContract.View getViewImpl() {
        return this;
    }

    @Override
    public void showError(int processCode, int errorCode, String message) {

    }

    @Override
    public void showLoading(int processCode, boolean show) {

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return childFragmentInjector;
    }
}
