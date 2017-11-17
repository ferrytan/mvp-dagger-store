package com.meetferrytan.mvpdaggerstore.presentation.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ferrytan on 8/2/17.
 */

public abstract class BaseMvpFragment<P extends BaseContract.Presenter<V>, V extends BaseContract.View> extends Fragment {
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    private P mPresenter;
    private Unbinder unbinder;

    public abstract void inject();

    protected abstract View createLayout(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    public abstract void processArguments(Bundle args);

    public abstract void startingUpFragment(View view, Bundle savedInstanceState);

    protected P getPresenter() {
        return mPresenter;
    }

    @Inject
    public void setPresenter(P presenter) {
        this.mPresenter = presenter;
        if (getViewImpl() == null) {
            throw new UnsupportedOperationException("Must provide MVP View");
        }
        mPresenter.attachView(getViewImpl());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // load layout
        View view = createLayout(inflater, container, savedInstanceState);

        // inject butter knife to init view
        unbinder = ButterKnife.bind(this, view);

        inject();
        // call init action
        processArguments(getArguments());
        startingUpFragment(view, savedInstanceState);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mPresenter.detachView();
    }

    @Override
    @NonNull
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }

    public abstract V getViewImpl();
}