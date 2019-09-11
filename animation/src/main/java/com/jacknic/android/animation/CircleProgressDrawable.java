package com.jacknic.android.animation;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

/**
 * 圆环进度可绘制类
 *
 * @author Jacknic
 */
public class CircleProgressDrawable extends Drawable implements Animatable,
        ValueAnimator.AnimatorUpdateListener {

    private static final String TAG = CircleProgressDrawable.class.getSimpleName();
    private static final int MAX_ANGLE = 360;
    private static final int MAX_LEVEL = 10000;
    private final int mDuration = 1000;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private ValueAnimator mAnimator = new ValueAnimator();

    public CircleProgressDrawable() {
        super();
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mAnimator.setInterpolator(new DecelerateInterpolator());
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setDuration(mDuration);
        mAnimator.setIntValues(0, MAX_LEVEL);
        mAnimator.addUpdateListener(this);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        float offset = mPaint.getStrokeWidth();
        RectF rect = new RectF(bounds);
        rect.inset(offset, offset);
        int colorStart = Color.parseColor("#FFAB0C");
        int colorEnd = Color.parseColor("#3EB042");
        LinearGradient linearGradient = new LinearGradient(bounds.left, bounds.top,
                bounds.right, bounds.bottom, colorStart, colorEnd, Shader.TileMode.REPEAT);
        mPaint.setShader(linearGradient);
        int level = getLevel();
        float percent = (level * 1f) / MAX_LEVEL;
        float startAngle = percent * MAX_ANGLE;
        float sweepAngle = level >= MAX_LEVEL ? 370 : 360 * percent;
        canvas.drawArc(rect, startAngle, sweepAngle, false, mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSPARENT;
    }

    @Override
    protected boolean onLevelChange(int level) {
        invalidateSelf();
        return true;
    }

    @Override
    public void start() {
        if (!mAnimator.isRunning()) {
            mAnimator.start();
        }
    }

    @Override
    public void stop() {
        if (mAnimator.isStarted()) {
            mAnimator.cancel();
        }
    }

    @Override
    public boolean isRunning() {
        return mAnimator.isRunning();
    }

    @Override
    public void onAnimationUpdate(@NotNull ValueAnimator animation) {
        setLevel((int) animation.getAnimatedValue());
    }
}
