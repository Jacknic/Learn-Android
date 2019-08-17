package com.jacknic.android.animation

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bitmaps.*

/**
 * 位图动画
 * Animate drawable graphics  |  Android Developers
 * https://developer.android.google.cn/guide/topics/graphics/drawable-animation.html
 */
class Bitmaps : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmaps)
        ivAnimation.setOnClickListener {
            val background = it.background
            if (background is AnimationDrawable) {
                if (background.isRunning) background.stop()
                else background.start()
            }
        }
    }
}
