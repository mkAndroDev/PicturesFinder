package com.krawczyk.maciej.models

import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalHits")
    val totalHits: Int,
    @SerializedName("hits")
    val hits: ArrayList<Hits> = arrayListOf()
)
