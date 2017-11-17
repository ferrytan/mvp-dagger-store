package com.meetferrytan.mvpdaggerstore.presentation.example;

import io.reactivex.Single;
import okio.BufferedSource;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ferrytan on 10/22/17.
 */

public interface ExampleRestInterface {
    @GET("users/{username}")
    Single<BufferedSource> getUserDetail(@Path("username") String username);
}
