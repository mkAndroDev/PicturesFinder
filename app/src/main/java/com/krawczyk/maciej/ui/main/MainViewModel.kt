package com.krawczyk.maciej.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krawczyk.maciej.searchUseCase.SearchExecutor
import com.krawczyk.maciej.searchUseCase.models.SearchDataItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val searchExecutor: SearchExecutor
) : ViewModel() {
    private val _pictures = MutableStateFlow<List<SearchDataItem>>(listOf())
    val pictures: StateFlow<List<SearchDataItem>> = _pictures.asStateFlow()

    init {
        searchPicture(DEFAULT_VALUE)
    }

    fun searchPicture(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            searchExecutor.provideSearchItems(query).collect {
                _pictures.emit(it)
            }
        }
    }

    fun onSearchDataItemClicked(searchDataItem: SearchDataItem) {
        Log.e("MACIEK", "onItemClicked = $searchDataItem")
    }

    private companion object {
        const val DEFAULT_VALUE = "flower"
    }
}