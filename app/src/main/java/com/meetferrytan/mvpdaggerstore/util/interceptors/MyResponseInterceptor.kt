package com.meetferrytan.mvpdaggerstore.util.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


/**
 * Created by ferrytan on 11/3/16.
 */

// TODO implement your own Interceptor, depends on your API response
class MyResponseInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        return chain.proceed(request)
    }
}