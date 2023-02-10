package com.krawczyk.maciej

import com.krawczyk.maciej.requests.PixabyService
import kotlinx.coroutines.flow.flow

class ApiHelper(private val pixabyService: PixabyService) {

    fun getPictures(query: String) = flow {
        emit(pixabyService.doGetUserList(query, APIClient.KEY))
    }
}