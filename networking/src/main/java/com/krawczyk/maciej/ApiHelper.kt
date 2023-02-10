package com.krawczyk.maciej

import kotlinx.coroutines.flow.flow
import okhttp3.Interceptor

class ApiHelper(interceptor: Interceptor) {

    private val pixabyService = APIClient.getService(interceptor)

    fun getPictures(query: String) = flow {
        emit(pixabyService.doGetUserList(KEY, query))
    }

    private companion object {
        const val KEY = "33537726-76c116d79d970104c5eacd0e9"
    }
}