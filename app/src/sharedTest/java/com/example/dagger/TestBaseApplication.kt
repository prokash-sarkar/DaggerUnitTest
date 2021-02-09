package com.example.dagger

import com.example.dagger.di.component.AppComponent
import com.example.dagger.di.component.DaggerTestAppComponent
import com.example.dagger.di.component.TestAppComponent

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

class TestBaseApplication : BaseApplication() {

    override fun initializeDaggerComponent(): AppComponent {
        val component: TestAppComponent = DaggerTestAppComponent.factory()
            .create(this)

        component.inject(this)

        return component
    }

}