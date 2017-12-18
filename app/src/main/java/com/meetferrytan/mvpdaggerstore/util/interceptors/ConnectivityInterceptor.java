package com.meetferrytan.mvpdaggerstore.util.interceptors;

/**
 * Created by ferrytan on 9/28/17.
 */

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.net.ConnectException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ConnectivityInterceptor implements Interceptor {
    public static final String NO_INTERNET_CONNECTION_MESSAGE = "No Connectivity Exception";
    private final ConnectivityManager mConnectivityManager;

    public ConnectivityInterceptor(ConnectivityManager connectivityManager) {
        mConnectivityManager = connectivityManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!isConnected()) {
            throw new ConnectException("Not connected to network");
        }

        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }

    private boolean isConnected() {
        NetworkInfo netInfo = mConnectivityManager.getActiveNetworkInfo();
        return (netInfo != null && netInfo.isConnected());
    }

}