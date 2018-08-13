package com.sbl.viewstudy;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = findViewById(R.id.tv_shape);
        GradientDrawable background = (GradientDrawable) textView.getBackground();//GradientDrawable是Drawable的子类
        background.setColor(Color.RED);//动态修改

    }
}
