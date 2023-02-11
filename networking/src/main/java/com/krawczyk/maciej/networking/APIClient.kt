package com.krawczyk.maciej.networking

import com.krawczyk.maciej.networking.requests.PixabyService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object APIClient {
    private fun getRetrofit(interceptor: Interceptor): Retrofit {
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(ApiData.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun getService(interceptor: Interceptor): PixabyService =
        getRetrofit(interceptor).create(PixabyService::class.java)
}