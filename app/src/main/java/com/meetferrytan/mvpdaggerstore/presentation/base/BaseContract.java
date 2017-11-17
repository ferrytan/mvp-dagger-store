package com.meetferrytan.mvpdaggerstore.presentation.base;

/**
 * Created by ferrytan on 7/4/17.
 */

public interface BaseContract {

    interface View {
        void showError(int processCode, int errorCode, String message);

        void showLoading(int processCode, boolean show);
    }

    interface Presenter<V extends View> {
        V getView();

        void attachView(V mvpView);

        void detachView();
    }
}
