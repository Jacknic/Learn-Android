package com.jacknic.android.paging.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jacknic.android.paging.api.WanApi
import com.jacknic.android.paging.model.Article
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WanRepository() {
    private val wanApi = Retrofit.Builder().baseUrl(WanApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(WanApi::class.java)

    fun getArticleList(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { WanPagingSource(wanApi) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }
}
