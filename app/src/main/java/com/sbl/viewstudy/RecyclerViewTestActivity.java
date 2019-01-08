package com.sbl.viewstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sbl.viewstudy.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author long
 * @date 2019/1/8.
 * description：
 */
public class RecyclerViewTestActivity extends AppCompatActivity {
    private RecyclerView Rv;
    private ArrayList<HashMap<String,Object>> listItem;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rl_main);

        // 初始化显示的数据
        initData();

        // 绑定数据到RecyclerView
        initView();

    }
    // 初始化显示的数据
    public void initData(){
        listItem = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/

        HashMap<String, Object> map1 = new HashMap<String, Object>();
        HashMap<String, Object> map2 = new HashMap<String, Object>();
        HashMap<String, Object> map3 = new HashMap<String, Object>();
        HashMap<String, Object> map4 = new HashMap<String, Object>();
        HashMap<String, Object> map5 = new HashMap<String, Object>();
        HashMap<String, Object> map6 = new HashMap<String, Object>();

        map1.put("ItemTitle", "特斯拉");
        map1.put("ItemText", "发件人: 来自未来");
        listItem.add(map1);

        map2.put("ItemTitle", "国际顺丰已收入");
        map2.put("ItemText", "等待中转");
        listItem.add(map2);

        map3.put("ItemTitle", "国际顺丰转件中");
        map3.put("ItemText", "下一站中国");
        listItem.add(map3);

        map4.put("ItemTitle", "中国顺丰已收入");
        map4.put("ItemText", "下一站北京市草央企去");
        listItem.add(map4);

        map5.put("ItemTitle", "中国顺丰派件中");
        map5.put("ItemText", "等待派件");
        listItem.add(map5);

        map6.put("ItemTitle", "立水桥收费站");
        map6.put("ItemText", "收件人:大黄蜂");
        listItem.add(map6);
    }

    // 绑定数据到RecyclerView
    public void initView(){
        Rv = (RecyclerView) findViewById(R.id.my_recycler_view);
        //使用线性布局
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        Rv.setLayoutManager(layoutManager);
        Rv.setHasFixedSize(true);

        //用自定义分割线类设置分割线
        Rv.addItemDecoration(new DividerItemDecoration(this));

        //为ListView绑定适配器
        myAdapter = new MyAdapter(this,listItem);
        Rv.setAdapter(myAdapter);
    }

}
