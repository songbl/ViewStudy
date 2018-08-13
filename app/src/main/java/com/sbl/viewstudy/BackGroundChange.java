package com.sbl.viewstudy;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;


public class BackGroundChange extends View {

    public BackGroundChange(Context context) {
        this(context, null);
    }
    public BackGroundChange(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.bgChanged);
        int color = ta.getColor(R.styleable.bgChanged_bgColor, 0xffff0000);
        setBackgroundColor(color);//自定义背景颜色
        ta.recycle();
    }
    public BackGroundChange(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }




}
