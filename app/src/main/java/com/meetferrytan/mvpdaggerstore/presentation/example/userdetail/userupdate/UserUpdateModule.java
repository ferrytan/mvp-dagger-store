package com.meetferrytan.mvpdaggerstore.presentation.example.userdetail.userupdate;

import com.google.gson.Gson;
import com.meetferrytan.mvpdaggerstore.data.entity.RepositorySearchResponse;
import com.meetferrytan.mvpdaggerstore.util.cache.StoreBarcode;
import com.meetferrytan.mvpdaggerstore.util.injection.scopes.ChildFragmentScope;
import com.nytimes.android.external.store3.base.Parser;
import com.nytimes.android.external.store3.base.Persister;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;
import com.nytimes.android.external.store3.middleware.GsonParserFactory;

import dagger.Module;
import dagger.Provides;
import okio.BufferedSource;
import retrofit2.Retrofit;

/**
 * Created by ferrytan on 24/12/17.
 */

@Module
public class UserUpdateModule {
    @Provides
    @ChildFragmentScope
    UserUpdateRestInterface provideApi(Retrofit retrofit) {
        return retrofit.create(UserUpdateRestInterface.class);
    }

    @Provides
    @ChildFragmentScope
    Store<RepositorySearchResponse, StoreBarcode> provideRepositorySearchStore(
            UserUpdateRestInterface api,
            Parser<BufferedSource, RepositorySearchResponse> parser,
            Persister<BufferedSource, StoreBarcode> persister) {
        return StoreBuilder.<StoreBarcode, BufferedSource, RepositorySearchResponse>parsedWithKey()
                .fetcher(barCode -> api.searchRepositories(barCode.getParameters()))
                .parser(parser)
                .persister(persister)
                .open();
    }

    @Provides
    @ChildFragmentScope
    Parser<BufferedSource, RepositorySearchResponse> provideRepositorySearchResponseParser(Gson gson) {
        return GsonParserFactory.createSourceParser(gson, RepositorySearchResponse.class);
    }
}
