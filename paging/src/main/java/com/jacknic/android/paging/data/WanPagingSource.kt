package com.jacknic.android.paging.data

import android.util.Log
import androidx.paging.PagingSource
import com.jacknic.android.paging.api.WanApi
import com.jacknic.android.paging.model.Article
import retrofit2.HttpException
import java.io.IOException

/**
 * @author Jacknic
 */
class WanPagingSource(private val wanApi: WanApi) : PagingSource<Int, Article>() {

    private val startIndex = 0
    private var currPage = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val position = params.key ?: startIndex
        return try {
            val response = wanApi.listArticle(position, null)
            val dataList = response.body()?.data?.datas ?: emptyList()
            Log.d(javaClass.name, "加载数据：第${position}页 - ${dataList.size}")
            LoadResult.Page(
                data = dataList,
                prevKey = if (position == startIndex) null else position - 1,
                nextKey = if (dataList.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}