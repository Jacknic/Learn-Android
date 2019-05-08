package com.jacknic.android.recyclerview.simple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.jacknic.android.recyclerview.R

class SimpleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val list = arrayListOf<String>()
        for (i in 0 until 50) {
            list.add("内容标题显示$i")
        }
        recyclerView.adapter = SimpleAdapter(list)
    }
}
