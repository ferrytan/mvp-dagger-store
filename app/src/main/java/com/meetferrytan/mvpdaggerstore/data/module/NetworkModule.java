package com.meetferrytan.mvpdaggerstore.data.module;

import android.app.Application;

import com.meetferrytan.mvpdaggerstore.BuildConfig;
import com.meetferrytan.mvpdaggerstore.util.format.BufferedSourceConverterFactory;
import com.meetferrytan.mvpdaggerstore.util.injection.DIConstants;
import com.meetferrytan.mvpdaggerstore.util.interceptors.MyRequestInterceptor;
import com.meetferrytan.mvpdaggerstore.util.interceptors.MyResponseInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by ferrytan on 10/18/17.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    @Named(DIConstants.BASE_URL)
    String provideBaseUrl() {
        return BuildConfig.BASE_URL;
    }

    @Provides
    @Singleton
    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache,
                                     MyRequestInterceptor requestInterceptor,
                                     MyResponseInterceptor responseInterceptor,
                                     HttpLoggingInterceptor httpLoggingInterceptor,
                                     @Named("NETWORK_TIMEOUT") int timeOUt) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(responseInterceptor)
                .cache(cache)
                .connectTimeout(timeOUt, TimeUnit.SECONDS)
                .readTimeout(timeOUt, TimeUnit.SECONDS)
                .writeTimeout(timeOUt, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(httpLoggingInterceptor);
        }
        return clientBuilder.build();
    }

    @Provides
    @Singleton
    @Named("NETWORK_TIMEOUT")
    int provideNetworkTimeOut() {
        return 20;
    }

    @Provides
    @Singleton
    MyResponseInterceptor provideCiayoResponseInterceptor() {
        return new MyResponseInterceptor();
    }

    @Provides
    @Singleton
    MyRequestInterceptor provideCiayoRequestInterceptor() {
        return new MyRequestInterceptor();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @Singleton
    RxJava2CallAdapterFactory provideRxJavaAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    BufferedSourceConverterFactory provideBufferedSourceConverterFactory() {
        return new BufferedSourceConverterFactory();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient,
                             @Named(DIConstants.BASE_URL) String baseUrl,
                             BufferedSourceConverterFactory bufferedSourceConverterFactory,
                             RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(bufferedSourceConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(okHttpClient)
                .build();
    }
}
