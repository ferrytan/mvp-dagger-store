package com.meetferrytan.mvpdaggerstore.presentation.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseMvpActivity<P extends BaseContract.Presenter<V>, V extends BaseContract.View> extends BaseActionBarActivity {
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    private P mPresenter;

    public abstract int setLayoutRes();

    public abstract void processIntentExtras(Bundle extras);

    public abstract void startingUpActivity(Bundle savedInstanceState);

    public abstract void inject();

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set content via create layout implement
        setContentView(setLayoutRes());
        ButterKnife.bind(this);
        inject();
        // init action
        processIntentExtras(getIntent().getExtras());
        startingUpActivity(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    @NonNull
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }

    public abstract V getViewImpl();
}