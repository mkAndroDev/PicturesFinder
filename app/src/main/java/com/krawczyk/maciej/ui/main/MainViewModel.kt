package com.krawczyk.maciej.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krawczyk.maciej.ApiHelper
import com.krawczyk.maciej.models.Hits
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiHelper: ApiHelper
) : ViewModel() {
    private val _pictures = MutableSharedFlow<List<Hits>>()
    val pictures: SharedFlow<List<Hits>> = _pictures

    fun searchPicture(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            apiHelper.getPictures(query).collect {
                _pictures.emit(it.hits)
            }
        }
    }
}