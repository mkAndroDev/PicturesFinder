package com.krawczyk.maciej.repository.models

data class SearchResult(
    val total: Int,
    val totalHits: Int,
    val hits: List<Hits> = arrayListOf()
) {
    companion object {
        fun createSearchResult(searchResult: com.krawczyk.maciej.networking.models.SearchResult): SearchResult {
            return SearchResult(
                searchResult.totalHits,
                searchResult.total,
                searchResult.hits.map { Hits.createHits(it) }
            )
        }
    }
}
