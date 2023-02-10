package com.krawczyk.maciej.requests

import retrofit2.http.GET
import retrofit2.http.Query

interface PixabyService {

    @GET("/api/users?")
    suspend fun doGetUserList(@Query("key") key: String, @Query("q") question: String): String?
}