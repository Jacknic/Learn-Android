package com.jacknic.android.paging.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jacknic.android.paging.model.Article

class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val title: TextView = view.findViewById(android.R.id.text1)

    fun bind(article: Article?) {
        article?.let {
            title.text = it.title
        }
    }

    companion object {
        fun create(parent: ViewGroup): ArticleViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_2, parent, false)
            return ArticleViewHolder(view)
        }
    }
}
