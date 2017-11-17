package com.meetferrytan.mvpdaggerstore.util.interceptors;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by ferrytan on 11/3/16.
 */

// TODO implement your own Interceptor, depends on your API response
public class MyResponseInterceptor implements Interceptor {
    public MyResponseInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        return response;
    }
}
