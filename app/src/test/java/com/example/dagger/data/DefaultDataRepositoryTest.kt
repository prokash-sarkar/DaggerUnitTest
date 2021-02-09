package com.example.dagger.data

import com.example.dagger.TestBaseApplication
import com.example.dagger.data.remote.model.Repo
import com.example.dagger.data.remote.model.RepoSearchResponse
import com.example.dagger.di.component.DaggerTestAppComponent
import com.example.dagger.di.component.TestAppComponent
import io.mockk.coEvery
import io.mockk.coVerify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

/**
 * Created by Prokash Sarkar on Sun, February 07, 2021
 * Copyright (c) 2021 Augmedix. All rights reserved.
 */

class DefaultDataRepositoryTest {

    @Inject
    lateinit var dataRepository: DefaultDataRepository

    @Inject
    lateinit var remoteDataSource: DataSource

    @Before
    fun setup() {
        val component: TestAppComponent = DaggerTestAppComponent.factory()
            .create(TestBaseApplication())
        component.inject(this)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getSearchResponse() = runBlockingTest {
        val repoList = mutableListOf<Repo>()
        val repo = Repo(1, "test_repo", "test_name", "test_desc", "test_url", 1, 1, "en")
        repoList.add(repo)
        val response = RepoSearchResponse(1, repoList)

        coEvery { remoteDataSource.getSearchResponse("android", 1, 1) } returns response

        dataRepository.getSearchResponse("android", 1, 1)

        coVerify { remoteDataSource.getSearchResponse("android", 1, 1) }
    }

}