package com.meetferrytan.mvpdaggerstore.presentation.example.fragment;

import com.meetferrytan.mvpdaggerstore.presentation.example.childfragment.ExampleChildFragment;
import com.meetferrytan.mvpdaggerstore.util.injection.scopes.ChildFragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ferrytan on 11/8/17.
 */

@Module
public abstract class ExampleFragmentBindingModule {
    @ChildFragmentScope
    @ContributesAndroidInjector
    abstract ExampleChildFragment exampleChildFragment();
}
