package com.jacknic.android.animation

import android.graphics.drawable.Animatable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import kotlinx.android.synthetic.main.activity_bitmaps.*


/**
 * @author Jacknic
 * @date 2019/06/23
 */
class Vectors : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vectors)
        val animatedVector = AnimatedVectorDrawableCompat.create(this, R.drawable.anim_battery_vector)
        ivAnimation.background = animatedVector
        ivAnimation.setOnClickListener {
            val background = it.background
            if (background is Animatable) {
                if (background.isRunning) background.stop()
                else background.start()
            }
        }
    }
}
