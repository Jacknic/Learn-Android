package com.jacknic.android.viewpager.basic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.jacknic.android.viewpager.R
import kotlin.math.abs

class BasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
        val pager = findViewById<ViewPager>(R.id.pager)
        pager.pageMargin = 30
        pager.adapter = BasicAdapter(supportFragmentManager)
        pager.setPageTransformer(true) { view: View, value: Float ->
            view.alpha = 1 - abs(value) * 0.5f
        }
    }
}
