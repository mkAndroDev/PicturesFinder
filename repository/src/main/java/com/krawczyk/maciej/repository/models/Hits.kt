package com.krawczyk.maciej.repository.models

data class Hits(
    val id: Int,
    val pageURL: String,
    val type: String,
    val tags: String,
    val previewURL: String,
    val previewWidth: Int,
    val previewHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int,
    val webformatHeight: Int,
    val largeImageURL: String,
    val imageWidth: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val views: Int,
    val downloads: Int,
    val collections: Int,
    val likes: Int,
    val comments: Int,
    val userId: Int,
    val user: String,
    val userImageURL: String
) {
    companion object {
        fun createHits(hits: com.krawczyk.maciej.networking.models.Hits): Hits {
            return Hits(
                hits.id,
                hits.pageURL,
                hits.type,
                hits.tags,
                hits.previewURL,
                hits.previewWidth,
                hits.previewHeight,
                hits.webformatURL,
                hits.webformatWidth,
                hits.webformatHeight,
                hits.largeImageURL,
                hits.imageWidth,
                hits.imageHeight,
                hits.imageSize,
                hits.views,
                hits.downloads,
                hits.collections,
                hits.likes,
                hits.comments,
                hits.userId,
                hits.user,
                hits.userImageURL
            )
        }
    }
}