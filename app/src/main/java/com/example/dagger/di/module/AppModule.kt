package com.example.dagger.di.module

import com.example.dagger.data.DataSource
import com.example.dagger.data.remote.RemoteDataSource
import com.example.dagger.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideTasksRemoteDataSource(
        apiService: ApiService
    ): DataSource {
        return RemoteDataSource(apiService)
    }

}