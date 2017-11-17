package com.meetferrytan.mvpdaggerstore.presentation.example;


import com.meetferrytan.mvpdaggerstore.presentation.example.fragment.ExampleFragment;
import com.meetferrytan.mvpdaggerstore.presentation.example.fragment.ExampleFragmentBindingModule;
import com.meetferrytan.mvpdaggerstore.util.injection.scopes.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by ferrytan on 11/8/17.
 */
@Module
public abstract class ExampleActivityBindingModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = ExampleFragmentBindingModule.class)
    abstract ExampleFragment exampleFragment();
}
