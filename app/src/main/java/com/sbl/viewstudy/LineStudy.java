package com.sbl.viewstudy;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class LineStudy extends View {

    private Paint paint;
    float dotToLeft;
    float dotToTop ;
    int paintColor;
    float startLineX;
    float startLineY;
    float endLineX;
    float endLineY;

    public LineStudy(Context context) {
        super(context);
    }

    public LineStudy(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.lineCustom);
        dotToLeft = ta.getDimension(R.styleable.lineCustom_dotToLeft, dp2px(getContext(),50));
        dotToTop = ta.getDimension(R.styleable.lineCustom_dotToTop,dotToLeft);
        startLineX = ta.getDimension(R.styleable.lineCustom_startLineX, dotToLeft);
        startLineY= ta.getDimension(R.styleable.lineCustom_startLineY, 0);
        endLineX= ta.getDimension(R.styleable.lineCustom_endLineX, dotToLeft);
        endLineY = ta.getDimension(R.styleable.lineCustom_endLineY, 3*dotToLeft);

        paintColor = ta.getColor(R.styleable.lineCustom_paintColor,0xffff0000);
        ta.recycle();
        initPaint();
    }

    public LineStudy(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(dotToLeft, dotToTop ,20,paint);
        canvas.drawLine(startLineX,startLineY,endLineX,endLineY,paint);
    }

    private void initPaint() {
        paint = new Paint();
        //设置画笔颜色
        paint.setColor(paintColor);
        //STROKE                //描边
        //FILL                  //填充
        //FILL_AND_STROKE       //描边加填充
        //设置画笔模式
        paint.setStyle(Paint.Style.FILL);
        //设置画笔宽度为30px
        paint.setStrokeWidth(10f);


    }


    /**
     * dp转换成px
     */
    private int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
