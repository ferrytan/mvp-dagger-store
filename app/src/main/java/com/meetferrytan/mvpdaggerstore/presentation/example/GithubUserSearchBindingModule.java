package com.meetferrytan.mvpdaggerstore.presentation.example;


import com.meetferrytan.mvpdaggerstore.presentation.example.userdetail.UserDetailBindingModule;
import com.meetferrytan.mvpdaggerstore.presentation.example.userdetail.UserDetailFragment;
import com.meetferrytan.mvpdaggerstore.util.injection.scopes.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ferrytan on 11/8/17.
 */
@Module
public abstract class GithubUserSearchBindingModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = UserDetailBindingModule.class)
    abstract UserDetailFragment userDetailFragment();
}
