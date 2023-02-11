package com.krawczyk.maciej.repository

import com.krawczyk.maciej.networking.ApiHelper
import com.krawczyk.maciej.networking.models.SearchResult
import com.krawczyk.maciej.storage.StorageProvider
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RepositoryTest {

    private val apiHelper: ApiHelper = mockk()
    private val storageProvider: StorageProvider = mockk()
    private val repository = Repository(apiHelper, storageProvider)

    @Test
    fun `get pictures by query call api for pictures`() = runBlocking {
        //GIVEN
        val query = "flower"
        val searchResult = SearchResult(0, 123, arrayListOf())
        coEvery { apiHelper.getPictures(query) } returns flow { searchResult }
        //WHEN
        repository.getPictures(query)
        //THEN
        coVerify(exactly = 1) { apiHelper.getPictures(query) }
    }

    @Test
    fun `get picture by id call api for picture`() = runBlocking {
        //GIVEN
        val id = "123"
        val searchResult = SearchResult(0, 123, arrayListOf())
        coEvery { apiHelper.getPicture(id) } returns flow { searchResult }
        //WHEN
        repository.getPicture(id)
        //THEN
        coVerify(exactly = 1) { apiHelper.getPicture(id) }
    }
}