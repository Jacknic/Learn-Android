package com.jacknic.android.animation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DrawableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawable)
        val drawable = CircleProgressDrawable()
        drawable.level = 6600
        val tvProgress = findViewById<TextView>(R.id.tvProgress)
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
