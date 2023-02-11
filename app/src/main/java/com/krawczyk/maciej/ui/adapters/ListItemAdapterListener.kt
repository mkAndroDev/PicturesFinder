package com.krawczyk.maciej.ui.adapters

import com.krawczyk.maciej.searchUseCase.models.SearchDataItem

class ListItemAdapterListener(
    private val onClickLister: (SearchDataItem) -> Unit
) {
    fun onSearchDataItemClicked(searchDataItem: SearchDataItem) {
        onClickLister.invoke(searchDataItem)
    }
}