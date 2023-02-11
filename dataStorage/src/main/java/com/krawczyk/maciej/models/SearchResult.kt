package com.krawczyk.maciej.models

internal data class SearchResult(
    val total: Int,
    val totalHits: Int,
    val hits: ArrayList<Hits> = arrayListOf()
)