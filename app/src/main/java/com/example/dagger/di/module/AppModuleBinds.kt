package com.example.dagger.di.module

import com.example.dagger.data.DataRepository
import com.example.dagger.data.DefaultDataRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

@Module
interface AppModuleBinds {

    @Singleton
    @Binds
    fun bindRepository(defaultDataRepository: DefaultDataRepository): DataRepository

}