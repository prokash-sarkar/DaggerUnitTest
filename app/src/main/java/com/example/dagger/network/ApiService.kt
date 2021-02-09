package com.example.dagger.network

import com.example.dagger.data.remote.model.RepoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

interface ApiService {

    /**
     * Get repos ordered by stars.
     */
    @GET("search/repositories?sort=stars")
    suspend fun searchRepos(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): RepoSearchResponse

}