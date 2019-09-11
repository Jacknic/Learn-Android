package com.jacknic.android.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_drawable.*

class DrawableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawable)
        val drawable = CircleProgressDrawable()
        drawable.level = 6600
        tvProgress.background = drawable
        tvProgress.setOnClickListener {
            if (drawable.isRunning) {
                drawable.stop()
            } else {
                drawable.start()
            }
        }
    }
}
