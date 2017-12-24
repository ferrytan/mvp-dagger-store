package com.meetferrytan.mvpdaggerstore.data.module;


import com.meetferrytan.mvpdaggerstore.presentation.example.GithubUserSearchActivity;
import com.meetferrytan.mvpdaggerstore.presentation.example.GithubUserSearchBindingModule;
import com.meetferrytan.mvpdaggerstore.presentation.example.GithubUserSearchModule;
import com.meetferrytan.mvpdaggerstore.util.injection.scopes.ActivityScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ferrytan on 11/3/17.
 */
@Module
public abstract class AndroidBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = {GithubUserSearchModule.class, GithubUserSearchBindingModule.class})
    abstract GithubUserSearchActivity githubUserSearchActivity();
}