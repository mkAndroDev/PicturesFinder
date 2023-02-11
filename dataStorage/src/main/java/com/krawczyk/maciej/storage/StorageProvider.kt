package com.krawczyk.maciej.storage

import com.krawczyk.maciej.models.Hits
import com.krawczyk.maciej.room.RoomDataStorage

class StorageProvider(
    private val roomDataStorage: RoomDataStorage
) {

    fun saveHits(hits: Hits) {
        roomDataStorage.saveToDb(hits)
    }

    fun readSearchResult() {

    }
}