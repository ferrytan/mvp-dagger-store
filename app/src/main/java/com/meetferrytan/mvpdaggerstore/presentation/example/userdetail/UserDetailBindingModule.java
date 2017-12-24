package com.meetferrytan.mvpdaggerstore.presentation.example.userdetail;

import com.meetferrytan.mvpdaggerstore.presentation.example.userdetail.userupdate.UserUpdateFragment;
import com.meetferrytan.mvpdaggerstore.presentation.example.userdetail.userupdate.UserUpdateModule;
import com.meetferrytan.mvpdaggerstore.util.injection.scopes.ChildFragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ferrytan on 11/8/17.
 */

@Module
public abstract class UserDetailBindingModule {
    @ChildFragmentScope
    @ContributesAndroidInjector(modules = UserUpdateModule.class)
    abstract UserUpdateFragment userUpdateFragment();
}
