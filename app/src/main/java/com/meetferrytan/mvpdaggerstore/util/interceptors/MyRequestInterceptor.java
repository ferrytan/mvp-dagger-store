package com.meetferrytan.mvpdaggerstore.util.interceptors;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ferrytan on 12/21/16.
 */

// TODO implement your own request interceptor
public class MyRequestInterceptor implements Interceptor {
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String AUTH_PREFIX = "Bearer ";

    public MyRequestInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest;
/*
        String token = authToken;
        if(!"".equals(token)) {
            newRequest = request.newBuilder()
                    .addHeader(HEADER_AUTHORIZATION, AUTH_PREFIX + token)
                    .build();
            return chain.proceed(newRequest);
        }*/
        return chain.proceed(request);
    }
}