package com.meetferrytan.mvpdaggerstore.data.component;

import com.meetferrytan.mvpdaggerstore.MyApp;
import com.meetferrytan.mvpdaggerstore.data.module.AndroidBindingModule;
import com.meetferrytan.mvpdaggerstore.data.module.BaseModule;
import com.meetferrytan.mvpdaggerstore.data.module.NetworkModule;
import com.meetferrytan.mvpdaggerstore.data.module.StoreModule;
import com.meetferrytan.mvpdaggerstore.util.schedulers.SchedulerModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by ferrytan on 10/20/17.
 */

@Component(
        modules = {
                BaseModule.class,
                NetworkModule.class,
                StoreModule.class,
                SchedulerModule.class,
                AndroidBindingModule.class,
                AndroidSupportInjectionModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<MyApp> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MyApp> {
    }
}