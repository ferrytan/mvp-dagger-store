package com.meetferrytan.mvpdaggerstore.util.schedulers

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import javax.inject.Qualifier

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class RunOn(val value: SchedulerType = SchedulerType.IO)