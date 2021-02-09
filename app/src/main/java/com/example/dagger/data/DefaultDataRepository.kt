package com.example.dagger.data

import com.example.dagger.data.remote.model.RepoSearchResponse
import javax.inject.Inject

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

class DefaultDataRepository @Inject constructor(
    private val remoteDataSource: DataSource
) : DataRepository {

    override suspend fun getSearchResponse(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): Result<RepoSearchResponse> {
        return try {
            val result = remoteDataSource.getSearchResponse(query, page, itemsPerPage)
            Result.Success(result)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}