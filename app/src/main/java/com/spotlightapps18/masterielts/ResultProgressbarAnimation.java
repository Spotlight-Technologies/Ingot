package com.spotlightapps18.masterielts;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;

import com.github.lzyzsd.circleprogress.DonutProgress;

public class ResultProgressbarAnimation extends Animation{

    DonutProgress progressBar;
    private float from, to;

    public ResultProgressbarAnimation(DonutProgress progressBar, float from, float to) {
        this.progressBar = progressBar;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int) value);
    }
}
