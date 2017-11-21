package com.meetferrytan.mvpdaggerstore.data.module;

import com.meetferrytan.mvpdaggerstore.util.cache.StoreBarcode;
import com.meetferrytan.mvpdaggerstore.util.injection.StoreCacheDir;
import com.nytimes.android.external.fs3.FileSystemRecordPersister;
import com.nytimes.android.external.fs3.PathResolver;
import com.nytimes.android.external.fs3.filesystem.FileSystemFactory;
import com.nytimes.android.external.store3.base.Persister;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okio.BufferedSource;
import timber.log.Timber;

/**
 * Created by ferrytan on 11/7/17.
 */

@Module
public class StoreModule {
    @Provides
    @Singleton
    PathResolver<StoreBarcode> providePathResolver() {
        return new PathResolver<StoreBarcode>() {
            @Nonnull
            @Override
            public String resolve(@Nonnull StoreBarcode barcode) {
                String resolver = barcode.getCacheKey();
                Timber.d("resolve cache for: " + resolver);
                return resolver;
            }
        };
    }

    @Provides
    @Singleton
    Persister<BufferedSource, StoreBarcode> providePersister(@StoreCacheDir File cacheDir, PathResolver<StoreBarcode> pathResolver) {
        try {
            // TODO default cache expiry in 24hrs
            return FileSystemRecordPersister.create(FileSystemFactory.create(cacheDir), pathResolver, 24, TimeUnit.HOURS);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }
}