package com.krawczyk.maciej.repository

import com.krawczyk.maciej.networking.ApiHelper
import com.krawczyk.maciej.repository.models.SearchResult
import com.krawczyk.maciej.storage.StorageProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Repository(
    private val apiHelper: ApiHelper,
    private val storageProvider: StorageProvider
) {

    suspend fun getPictures(query: String) =
        apiHelper.getPictures(query).map { SearchResult.createSearchResult(it) }

    suspend fun getPicture(id: String): Flow<SearchResult> {
        //TODO: 1 step - return saved from storage
        //TODO: 2 step - api call and save to storageProvider
        //TODO: 3 step - return newest value
        return apiHelper.getPicture(id).map { SearchResult.createSearchResult(it) }
    }
}