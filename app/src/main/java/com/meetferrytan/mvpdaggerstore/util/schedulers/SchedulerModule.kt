package com.meetferrytan.mvpdaggerstore.util.schedulers

import com.meetferrytan.mvpdaggerstore.util.schedulers.SchedulerType.*
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
class SchedulerModule {
    @Provides
    @RunOn(IO)
    fun provideIo(): Scheduler = Schedulers.io()

    @Provides
    @RunOn(COMPUTATION)
    fun provideComputation(): Scheduler = Schedulers.computation()

    @Provides
    @RunOn(UI)
    fun provideUi(): Scheduler = AndroidSchedulers.mainThread()
}