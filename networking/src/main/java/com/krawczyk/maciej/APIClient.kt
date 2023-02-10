package com.krawczyk.maciej

import com.krawczyk.maciej.requests.PixabyService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    private const val BASE_URL = "https://pixabay.com/api/"
    const val KEY = "33537726-76c116d79d970104c5eacd0e9"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: PixabyService = getRetrofit().create(PixabyService::class.java)
}