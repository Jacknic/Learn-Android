package com.jacknic.android.recyclerview.list

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jacknic.android.recyclerview.R
import java.util.*

class ListActivity : AppCompatActivity() {

    private lateinit var myListAdapter: MyListAdapter
    private val list = arrayListOf<String>()
    private var pageNum = 0
    private val pageSize = 10

    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            println("收到消息：${msg?.what}")
            msg?.apply {
                if (what == 0 && list.size < 1000) {
                    val pageStart = pageNum * pageSize
                    for (i in 0 until pageSize) {
                        list.add("内容标题显示${i + pageStart}")
                    }
                    myListAdapter.notifyItemRangeChanged(pageStart, pageSize)
                    pageNum++
                    sendEmptyMessageDelayed(0, 5000)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        myListAdapter = MyListAdapter(object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String) = Objects.equals(oldItem, newItem)
            override fun areContentsTheSame(oldItem: String, newItem: String) = Objects.equals(oldItem, newItem)
        })
        recyclerView.adapter = myListAdapter
        myListAdapter.submitList(list)
        handler.sendEmptyMessage(0)
    }
}
