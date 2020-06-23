package com.jacknic.android.paging.api

import com.jacknic.android.paging.data.WanJson
import com.jacknic.android.paging.model.Article
import com.jacknic.android.paging.model.PageList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 玩Android 开放API
 *
 *https://wanandroid.com/blog/show/2
 */
interface WanApi {

    /**
     * 获取文章列表
     * @param pageNo 页码
     * @param cid 分类ID
     */
    @GET("/article/list/{pageNo}/json")
    suspend fun listArticle(
        @Path("pageNo") pageNo: Int,
        @Query("cid") cid: Int?
    ): Response<WanJson<PageList<Article>>>

    companion object {
        const val BASE_URL = "https://wanandroid.com/"
    }
}