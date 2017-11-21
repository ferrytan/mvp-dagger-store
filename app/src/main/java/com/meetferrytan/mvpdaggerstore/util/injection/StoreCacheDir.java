package com.meetferrytan.mvpdaggerstore.util.injection;

/**
 * Created by ferrytan on 11/6/17.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface StoreCacheDir {
}