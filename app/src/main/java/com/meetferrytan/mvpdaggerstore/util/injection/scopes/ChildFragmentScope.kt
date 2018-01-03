package com.meetferrytan.mvpdaggerstore.util.injection.scopes

/**
 * Created by ferrytan on 11/8/17.
 */

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import javax.inject.Scope

/**
 * Created by ferrytan on 11/6/17.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ChildFragmentScope