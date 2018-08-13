package com.sbl.viewstudy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ScrapeView extends View {
    private static final String TAG = "songbl";
    private int width;
    private int height;
    private String text = "恭喜你，中奖啦....";
    private Paint textPaint;
    private Paint paint;
    private Path path;
    private float downX, downY;
    private float tempX, tempY;
    private float sumX, movedDistance;
    private Canvas myCanvas;
    private Bitmap myBitmap;
    private Bitmap bgBitmap;
    boolean isFinish = false;

    public ScrapeView(Context context) {
        this(context, null);
    }

    public ScrapeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrapeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(72);
        paint.setDither(true);
        paint.setAntiAlias(true);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(100);
        textPaint.setDither(true);
        textPaint.setColor(Color.RED);

        path = new Path();
        bgBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.guide_one);//第一张图
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        myBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        myCanvas = new Canvas(myBitmap);
        myCanvas.drawColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bgBitmap, 0, 0, null);//底层图
        drawText(canvas);
        drawPath();
        canvas.drawBitmap(myBitmap, 0, 0, null);
        super.onDraw(canvas);
        if (isFinish) {
            canvas.drawBitmap(bgBitmap, 0, 0, null);
            drawText(canvas);
        }
    }

    private void drawText(Canvas canvas) {
        Rect rect = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), rect);
        int textWidth = rect.width();
        int textHeight = rect.height();
        float x = width / 2 - textWidth / 2;
        float y = height / 2 + textHeight / 2;
        canvas.drawText(text, x, y, textPaint);
    }

    private void drawPath() {
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        myCanvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downY = event.getY();
                path.moveTo(downX, downY);
                invalidate();
                Log.e("songbl", "ACTION_DOWN downX===" + event.getX()+"ACTION_DOWN downY===" + event.getY() );
                tempX = downX;
                tempY = downY;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("songbl", "移动在不断进行中.........");
                float moveX = event.getX();
                float moveY = event.getY();
                path.quadTo(tempX, tempY, moveX, moveY);
                invalidate();
                Log.e("songbl", "ACTION_MOVE moveX===" + event.getX()+"ACTION_DOWN moveY===" + event.getY() );

                movedDistance = moveX - tempX;
                tempX = moveX;
                tempY = moveY;
                Log.e("songbl", "movedDistance===" + movedDistance + " ........... " + "width===" + width);
                if (movedDistance > 0) {
                    sumX = sumX + movedDistance;
                }

                break;
            case MotionEvent.ACTION_UP:
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            if (sumX > width * 2) {
                                isFinish = true;
                                Thread.sleep(500);
                                postInvalidate();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                break;
        }
        return true;
    }
}
