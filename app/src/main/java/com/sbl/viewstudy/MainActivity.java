package com.sbl.viewstudy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;
    TextView textView ;
    Button button1,button2;
    ViewGroup myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout_dispatch);
//        imageView = findViewById(R.id.iv);

        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534781721731&di=c5e66f7a9a81c5159c9e67faf4e92acf&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fe824b899a9014c086ccf1296077b02087bf4f408.jpg";

     //   TextView textView = findViewById(R.id.tv_shape);
//        GradientDrawable background = (GradientDrawable) textView.getBackground();//GradientDrawable是Drawable的子类
//        background.setColor(Color.RED);//动态修改

//        Glide.with(this)
//                .load(url)
//                .asBitmap()
//                .into(new TransformationUtils(imageView));


//        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534781721731&di=c5e66f7a9a81c5159c9e67faf4e92acf&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fe824b899a9014c086ccf1296077b02087bf4f408.jpg").asBitmap()
//                .into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
//                    @Override
//                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                        int imageWidth = resource.getWidth();
//                        int imageHeight = resource.getHeight();
//                    //    int width = ScreentUtils.getScreenWidth(context);//固定宽度
//                        int width = getScreenWidth();//固定宽度
//                        int height = getScreenHeight()/2;
//                        //宽度固定,然后根据原始宽高比得到此固定宽度需要的高度
//                        float height = (float)width / (float)imageWidth * (float)imageHeight;
//                        ViewGroup.LayoutParams para = imageView.getLayoutParams();
//                        para.height = (int) height;
//                        para.width = width;
//                        imageView.setImageBitmap(resource);
//                    }
//                });

//
//        Glide.with(this).load(url).asBitmap().into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
//            @Override
//            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                int imageWidth = resource.getWidth();
//                int imageHeight = resource.getHeight();
//
//            //    int height = dp(360) * imageHeight / imageWidth;
//                float height = 0.2f * imageHeight / imageWidth;
//                ViewGroup.LayoutParams para = imageView.getLayoutParams();
//                para.height = (int) height;
//                para.width = dp(360);
//                imageView.setImageBitmap(resource);
//            }
//        });

            button1 = (Button)findViewById(R.id.button1);
            button2 = (Button)findViewById(R.id.button2);
            myLayout = (LinearLayout)findViewById(R.id.my_layout);

            // 1.为ViewGroup布局设置监听事件
        /**
         * 在点击空白处时候（即没有任何View接收事件），或者拦截了事件（手动复写了onInterceptTouchEvent，从而让其返回true）
         * 会调用   super.dispatchTouchEvent(ev) ,调用ViewGroup父类的dispatchTouchEvent（），就是View的方法。感觉是继承来的，父类的这几个方法；还是执行ViewGroup自己的onTouch（）
         * onTouchEvent（） performClick（）。
         */
            myLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("TAG", "点击了ViewGroup");
                }
            });

            // 2. 为按钮1设置监听事件
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("TAG", "点击了button1");
                }
            });

            // 3. 为按钮2设置监听事件
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("TAG", "点击了button2");
                }
            });




    }

    public int dp(float dp) {
        return (int) (dp * DENSITY + 0.5f);
    }

    /**
     * 获得屏幕宽度
     *
     * @return px
     */
    public static int getScreenWidth() {
        WindowManager wm = (WindowManager) App.getApplication()
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获得屏幕高度
     *
     * @return px
     */
    public static int getScreenHeight() {
        WindowManager wm = (WindowManager) App.getApplication()
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    /**
     * 屏幕密度,系统源码注释不推荐使用
     */
    public static final float DENSITY = Resources.getSystem()
            .getDisplayMetrics().density;

}
