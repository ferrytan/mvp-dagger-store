package com.meetferrytan.mvpdaggerstore.presentation.base;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.meetferrytan.mvpdaggerstore.util.callback.RequestCallback;

import java.lang.ref.WeakReference;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public abstract class BasePresenter<V extends BaseContract.View>
        implements BaseContract.Presenter<V>,
        LifecycleObserver {
    private WeakReference<V> viewRef; // Use WeakReference so setting the presenter to null during onDestroy is not really required
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void attachView(V mvpView) {
        viewRef = new WeakReference<>(mvpView);
        setupLifecycleAwareListener();
    }

    @Override
    public void detachView() {
        clearDisposable();
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    @Override
    public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    /**
     * @param single          -> Single request to process.
     * @param processId       -> unique processId from child presenter
     * @param requestCallback -> request callback
     * @param <F>             -> generic response object
     */
    protected <F> void processSingleRequest(Single<F> single, int processId, RequestCallback<F> requestCallback) {
        getView().showLoading(processId, true);
        addDisposable(single.subscribe(f -> {
            requestCallback.onRequestSuccess(f);
            getView().showLoading(processId, false);
        }, throwable -> {
            getView().showLoading(processId, false);
            processError(processId, throwable);
        }));
    }

    /**
     * add disposable to container
     *
     * @param disposable
     */
    private void addDisposable(Disposable disposable) {
        this.mCompositeDisposable.add(disposable);
    }

    /**
     * clear disposables
     */
    private void clearDisposable() {
        this.mCompositeDisposable.clear();
    }

    /**
     * Use this method if you use your own custom exception with errorCode and Message
     *
     * @param processCode
     * @param throwable
     */
    private void processError(int processCode, Throwable throwable) {
        Timber.e(throwable);
        getView().showError(processCode, throwable.hashCode(), throwable.getLocalizedMessage());
        /*if (throwable instanceof MyRestException) {
            MyRestException ciayoRestException = ((MyRestException)throwable);
            int errorCode = ciayoRestException.getErrorCode();
            String message = ciayoRestException.getMessage();
            getView().showError(processCode, errorCode, message);
        }else{
            getView().showError(processCode, -1, "");
        }*/
    }

    /**
     * setup presenter to be aware of view's lifecycle
     */
    public void setupLifecycleAwareListener() {
        try {
            ((LifecycleOwner) getView()).getLifecycle().addObserver(this);
        } catch (ClassCastException cce) {
            throw new ClassCastException(getView().toString() + " must implement LifecycleOwner");
        }
    }

    /**
     * Lifecycle Methods.
     * Override these methods in child presenter class to let the presenter know the view lifecycle.
     * make sure to check Lifecycle.getCurrentState before accessing instance which can be destroyed / not yet created.
     */

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
    }
}