package com.example.dagger.di.component

import android.content.Context
import com.example.dagger.BaseApplication
import com.example.dagger.di.ViewModelBuilderModule
import com.example.dagger.di.module.ActivityBuildersModule
import com.example.dagger.di.module.AppModule
import com.example.dagger.di.module.AppModuleBinds
import com.example.dagger.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

// When a type is marked with a scope annotation, it can only be used by components that are annotated with the same scope.
// When a component is marked with a scope annotation, it can only provide types with that annotation or types that have no annotation.
// A subcomponent cannot use a scope annotation used by one of its parent components.
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class, NetworkModule::class,
        AppModule::class, AppModuleBinds::class,
        ViewModelBuilderModule::class, ActivityBuildersModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun inject(app: BaseApplication)

}