package com.krawczyk.maciej.networking

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import okhttp3.Interceptor

class ApiHelper(interceptor: Interceptor) {

    private val pixabyService = APIClient.getService(interceptor)

    suspend fun getPictures(query: String) = withContext(Dispatchers.IO) {
        flow {
            emit(pixabyService.doGetPicturesByQuery(ApiData.API_KEY, query))
        }
    }

    suspend fun getPicture(id: String) = withContext(Dispatchers.IO) {
        flow {
            emit(pixabyService.doGetPicturesById(ApiData.API_KEY, id))
        }
    }
}