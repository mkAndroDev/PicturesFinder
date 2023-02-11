package com.krawczyk.maciej.networking.requests

import com.krawczyk.maciej.networking.models.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabyService {

    @GET("/api/?")
    suspend fun doGetPicturesByQuery(
        @Query("key") key: String,
        @Query("q") query: String
    ): SearchResult

    @GET("/api/?")
    suspend fun doGetPicturesById(
        @Query("key") key: String,
        @Query("id") id: String
    ): SearchResult
}