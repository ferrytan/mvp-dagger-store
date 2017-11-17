package com.meetferrytan.mvpdaggerstore.presentation.example;

import com.google.gson.Gson;
import com.meetferrytan.mvpdaggerstore.data.entity.User;
import com.meetferrytan.mvpdaggerstore.util.cache.StoreBarcode;
import com.meetferrytan.mvpdaggerstore.util.injection.scopes.ActivityScope;
import com.nytimes.android.external.store3.base.Parser;
import com.nytimes.android.external.store3.base.Persister;
import com.nytimes.android.external.store3.base.impl.Store;
import com.nytimes.android.external.store3.base.impl.StoreBuilder;
import com.nytimes.android.external.store3.middleware.GsonParserFactory;

import dagger.Module;
import dagger.Provides;
import okio.BufferedSource;
import retrofit2.Retrofit;
import timber.log.Timber;

/**
 * Created by ferrytan on 11/6/17.
 */

@Module
public class ExampleActivityModule {
    @Provides
    @ActivityScope
    ExampleRestInterface provideExampleApi(Retrofit retrofit) {
        return retrofit.create(ExampleRestInterface.class);
    }

    @Provides
    @ActivityScope
    Store<User, StoreBarcode> provideUserDetailStore(
            ExampleRestInterface api,
            Parser<BufferedSource, User> parser,
            Persister<BufferedSource, StoreBarcode> persister) {
        Timber.d("provideBannerStore");
        return StoreBuilder.<StoreBarcode, BufferedSource, User>parsedWithKey()
                .fetcher(barCode -> api.getUserDetail(barCode.getPaths().get(0)))
                .parser(parser)
                .persister(persister)
                .open();
    }

    @Provides
    @ActivityScope
    Parser<BufferedSource, User> provideBannerParser(Gson gson) {
        return GsonParserFactory.createSourceParser(gson, User.class);
    }

}
