package com.meetferrytan.mvpdaggerstore.util.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

/**
 * Created by ferrytan on 12/21/16.
 */

// TODO implement your own request interceptor
class MyRequestInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest: Request
        /*
        String token = authToken;
        if(!"".equals(token)) {
            newRequest = request.newBuilder()
                    .addHeader(HEADER_AUTHORIZATION, AUTH_PREFIX + token)
                    .build();
            return chain.proceed(newRequest);
        }*/
        return chain.proceed(request)
    }

    companion object {
        private val HEADER_AUTHORIZATION = "Authorization"
        private val AUTH_PREFIX = "Bearer "
    }
}