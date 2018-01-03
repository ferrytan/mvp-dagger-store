package com.meetferrytan.mvpdaggerstore

import android.content.Context
import android.support.multidex.MultiDex

import com.facebook.stetho.Stetho
import com.meetferrytan.mvpdaggerstore.data.component.DaggerAppComponent
import com.squareup.leakcanary.LeakCanary

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

/**
 * Created by ferrytan on 11/17/17.
 */

class MyApp : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
        }

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}