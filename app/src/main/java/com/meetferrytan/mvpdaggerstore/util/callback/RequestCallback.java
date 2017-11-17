package com.meetferrytan.mvpdaggerstore.util.callback;

/**
 * Created by ferrytan on 10/22/17.
 */

public interface RequestCallback<R> {
    void onRequestSuccess(R result);
}
