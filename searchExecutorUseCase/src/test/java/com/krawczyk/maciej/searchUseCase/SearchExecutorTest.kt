package com.krawczyk.maciej.searchUseCase

import com.krawczyk.maciej.repository.Repository
import com.krawczyk.maciej.repository.models.SearchResult
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SearchExecutorTest {

    private val repository: Repository = mockk()
    private val searchExecutor = SearchExecutor(repository)

    @Test
    fun `search for pictures invoke call on repository getPictures exactly once`() = runBlocking {
        //GIVEN
        val query = "flower"
        val searchResult = SearchResult(0, 123, arrayListOf())
        coEvery { repository.getPictures(query) } returns flow { searchResult }
        //WHEN
        searchExecutor.provideSearchItems(query)
        //THEN
        coVerify(exactly = 1) { repository.getPictures(query) }
    }
}