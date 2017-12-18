package com.meetferrytan.mvpdaggerstore.data.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.meetferrytan.mvpdaggerstore.MyApp;
import com.meetferrytan.mvpdaggerstore.util.injection.StoreCacheDir;

import java.io.File;
import java.lang.reflect.Type;
import java.util.Collection;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ferrytan on 10/18/17.
 */

@Module
public abstract class BaseModule {

    @Binds
    abstract Application application(MyApp app);

    @Provides
    @StoreCacheDir
    @Singleton
    static File provideCacheDir(Application application) {
        return application.getCacheDir();
    }

    @Provides
    @Singleton
    static SharedPreferences provideDefaultSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    static Gson provideGson(CollectionAdapter collectionAdapter) {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeHierarchyAdapter(Collection.class, collectionAdapter)
                .serializeNulls()
                .disableHtmlEscaping();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    static CollectionAdapter provideCollectionAdapter() {
        return new CollectionAdapter();
    }

    public static class CollectionAdapter implements JsonSerializer<Collection<?>> {
        @Override
        public JsonElement serialize(Collection<?> src, Type typeOfSrc, JsonSerializationContext context) {
            if (src == null || src.isEmpty()) // exclusion is made here
                return null;

            JsonArray array = new JsonArray();

            for (Object child : src) {
                JsonElement element = context.serialize(child);
                array.add(element);
            }

            return array;
        }
    }

    @Provides
    @Singleton
    static ConnectivityManager provideConnectivityManager(Application application){
        return (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}