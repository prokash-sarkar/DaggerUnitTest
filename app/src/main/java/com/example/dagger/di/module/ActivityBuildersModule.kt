package com.example.dagger.di.module

import com.example.dagger.di.scopes.ActivityScope
import com.example.dagger.ui.main.MainActivity
import com.example.dagger.ui.main.di.MainFragmentsBuilderModule
import com.example.dagger.ui.main.di.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

@Module
interface ActivityBuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class, MainFragmentsBuilderModule::class])
    fun contributeMainActivity(): MainActivity

}