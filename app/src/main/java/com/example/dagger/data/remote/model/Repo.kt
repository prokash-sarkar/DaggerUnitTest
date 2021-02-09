package com.example.dagger.data.remote.model

import com.google.gson.annotations.SerializedName

/**
Created by Prokash Sarkar on Tue, January 19, 2021
 **/

/**
 * Immutable model class for a Github repo that holds all the information about a repository.
 * Objects of this type are received from the Github API, therefore all the fields are annotated
 * with the serialized name.
 * This class also defines the Room repos table, where the repo [id] is the primary key.
 */
data class Repo(
    // Gson
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("description") val description: String?,
    @SerializedName("html_url") val url: String,
    @SerializedName("stargazers_count") val stars: Int,
    @SerializedName("forks_count") val forks: Int,
    @SerializedName("language") val language: String?

    // Moshi
    /*@Json(name ="id") val id: Long,
    @Json(name ="name") val name: String,
    @Json(name ="full_name") val fullName: String,
    @Json(name ="description") val description: String?,
    @Json(name ="html_url") val url: String,
    @Json(name ="stargazers_count") val stars: Int,
    @Json(name ="forks_count") val forks: Int,
    @Json(name ="language") val language: String?*/
)