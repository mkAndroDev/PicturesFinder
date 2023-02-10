package com.krawczyk.maciej

import kotlinx.coroutines.flow.flow
import okhttp3.Interceptor

class ApiHelper(interceptor: Interceptor) {

    private val pixabyService = APIClient.getService(interceptor)

    fun getPictures(query: String) = flow {
        emit(pixabyService.doGetUserList(ApiData.API_KEY, query))
    }
}