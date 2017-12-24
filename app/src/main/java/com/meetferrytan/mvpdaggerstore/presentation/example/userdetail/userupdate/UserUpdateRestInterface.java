package com.meetferrytan.mvpdaggerstore.presentation.example.userdetail.userupdate;

import java.util.Map;

import io.reactivex.Single;
import okio.BufferedSource;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by ferrytan on 24/12/17.
 */

public interface UserUpdateRestInterface {
    @GET("https://api.github.com/search/repositories")
    Single<BufferedSource> searchRepositories(@QueryMap(encoded = true) Map<String, String> params);
}
