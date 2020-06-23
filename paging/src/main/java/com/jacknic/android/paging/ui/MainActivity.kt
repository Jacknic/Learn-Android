package com.jacknic.android.paging.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.RecyclerView
import com.jacknic.android.paging.R
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    @ExperimentalCoroutinesApi
    private val vm by viewModels<SearchRepositoriesViewModel>()
    private val articleAdapter = ArticleAdapter()

    @ExperimentalPagingApi
    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvArticleList = findViewById<RecyclerView>(R.id.rvArticleList)
        rvArticleList.adapter = articleAdapter
        lifecycleScope.launch {
            vm.searchRepo().collectLatest {
                articleAdapter.submitData(it)
            }
        }
        articleAdapter.addDataRefreshListener {

        }
        articleAdapter.addLoadStateListener {
            it.append
        }
    }
}
