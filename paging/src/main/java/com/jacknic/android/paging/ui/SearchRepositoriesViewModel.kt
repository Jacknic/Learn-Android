package com.jacknic.android.paging.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.jacknic.android.paging.data.WanRepository
import com.jacknic.android.paging.model.Article
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

/**
 *
 */
@ExperimentalCoroutinesApi
class SearchRepositoriesViewModel() : ViewModel() {
    private val repository: WanRepository = WanRepository()
    private var currentSearchResult: Flow<PagingData<Article>>? = null

    fun searchRepo(): Flow<PagingData<Article>> {
        if (currentSearchResult != null) {
            return currentSearchResult as Flow<PagingData<Article>>
        }
        val newResult: Flow<PagingData<Article>> = repository.getArticleList()
            .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }

}