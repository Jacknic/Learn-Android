package com.jacknic.android.animation

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * 位图动画
 * Animate drawable graphics  |  Android Developers
 * https://developer.android.google.cn/guide/topics/graphics/drawable-animation.html
 */
class Bitmaps : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmaps)
        val ivAnimation = findViewById<ImageView>(R.id.ivAnimation)
        ivAnimation.setOnClickListener {
            val background = it.background
            if (background is AnimationDrawable) {
                if (background.isRunning) background.stop()
                else background.start()
            }
        }
    }
}
