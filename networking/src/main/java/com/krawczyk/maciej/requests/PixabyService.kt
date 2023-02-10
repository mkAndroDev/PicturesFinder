package com.krawczyk.maciej.requests

import com.krawczyk.maciej.models.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabyService {

    @GET("/api/?")
    suspend fun doGetUserList(@Query("key") key: String, @Query("q") question: String): SearchResult
}