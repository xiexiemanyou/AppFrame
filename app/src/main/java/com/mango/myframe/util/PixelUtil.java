package com.mango.myframe.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.mango.myframe.MyFrameApp;


public class PixelUtil {

    private static DisplayMetrics mMetrics;
    private static PixelUtil mInstance;

    private PixelUtil(){
        Context context = MyFrameApp.getInstance();
        Resources resources = context.getResources();
        mMetrics = resources.getDisplayMetrics();
    }

    public static PixelUtil getInstance(){
        if(mInstance == null){
            mInstance = new PixelUtil();
        }
        return mInstance;
    }

    public float dpToPx(float dp) {
        float a = mMetrics.densityDpi;

        return dp * ((float) mMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public float pxToDp(float px) {

        return px / ((float) mMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public float spToPx(float sp) {

        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, mMetrics);
    }

    public float pxToSp(float px) {

        return px / mMetrics.scaledDensity;
    }
}
