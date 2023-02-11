package com.krawczyk.maciej.searchUseCase.models

import com.krawczyk.maciej.repository.models.Hits

data class SearchDataItem(
    val previewURL: String,
    val user: String,
    val tags: String
) {
    companion object {
        fun createSearchDataItem(hits: Hits): SearchDataItem {
            return SearchDataItem(hits.previewURL, hits.user, hits.tags)
        }
    }
}
