package com.example.dagger.di.component

import android.content.Context
import com.example.dagger.TestBaseApplication
import com.example.dagger.data.DefaultDataRepositoryTest
import com.example.dagger.di.ViewModelBuilderModule
import com.example.dagger.di.module.ActivityBuildersModule
import com.example.dagger.di.module.AppModuleBinds
import com.example.dagger.di.module.NetworkModule
import com.example.dagger.di.module.TestAppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class, NetworkModule::class,
        TestAppModule::class, AppModuleBinds::class,
        ViewModelBuilderModule::class, ActivityBuildersModule::class
    ]
)
interface TestAppComponent : AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): TestAppComponent
    }

    fun inject(app: TestBaseApplication)

    fun inject(test: DefaultDataRepositoryTest)

}