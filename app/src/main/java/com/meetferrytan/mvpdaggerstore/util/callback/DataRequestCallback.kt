package com.meetferrytan.mvpdaggerstore.util.callback

/**
 * Created by ferrytan on 10/22/17.
 */

interface DataRequestCallback<R> {
    fun onRequestSuccess(result: R)
}