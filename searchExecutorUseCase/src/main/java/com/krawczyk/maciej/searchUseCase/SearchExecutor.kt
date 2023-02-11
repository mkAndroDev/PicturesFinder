package com.krawczyk.maciej.searchUseCase

import com.krawczyk.maciej.repository.Repository
import com.krawczyk.maciej.searchUseCase.models.SearchDataItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SearchExecutor(
    private val repository: Repository
) {

    suspend fun provideSearchItems(query: String): Flow<List<SearchDataItem>> {
        return repository.getPictures(query)
            .map { it.hits.map { SearchDataItem.createSearchDataItem(it) } }
    }
}