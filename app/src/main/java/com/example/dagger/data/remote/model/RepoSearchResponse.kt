package com.example.dagger.data.remote.model

import com.google.gson.annotations.SerializedName

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

/**
 * Data class to hold repo responses from searchRepo API calls.
 */
data class RepoSearchResponse(
    // Gson
    @SerializedName("total_count") val total: Int = 0,
    @SerializedName("items") val items: List<Repo> = emptyList(),

    // Moshi
    /*@Json(name = "total_count") val total: Int = 0,
    @Json(name = "items") val items: List<Repo> = emptyList(),*/

    val nextPage: Int? = null
)
