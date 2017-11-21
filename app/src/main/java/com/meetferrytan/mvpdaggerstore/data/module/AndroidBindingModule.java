package com.meetferrytan.mvpdaggerstore.data.module;


import com.meetferrytan.mvpdaggerstore.presentation.example.ExampleActivity;
import com.meetferrytan.mvpdaggerstore.presentation.example.ExampleActivityBindingModule;
import com.meetferrytan.mvpdaggerstore.presentation.example.ExampleActivityModule;
import com.meetferrytan.mvpdaggerstore.util.injection.scopes.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ferrytan on 11/3/17.
 */
@Module
public abstract class AndroidBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = {ExampleActivityModule.class, ExampleActivityBindingModule.class})
    abstract ExampleActivity exampleActivity();
}