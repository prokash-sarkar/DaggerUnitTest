package com.example.dagger.data.remote

import com.example.dagger.data.DataSource
import com.example.dagger.data.remote.model.RepoSearchResponse
import com.example.dagger.network.ApiService
import javax.inject.Inject

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) : DataSource {

    private val IN_QUALIFIER = "in:name,description"

    override suspend fun getSearchResponse(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): RepoSearchResponse {
        return apiService.searchRepos(
            "$query $IN_QUALIFIER",
            page,
            itemsPerPage
        )
    }

}