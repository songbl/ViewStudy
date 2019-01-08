package com.sbl.viewstudy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sbl.viewstudy.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author long
 * @date 2019/1/8.
 * description：
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Viewholder> {
   private LayoutInflater layoutInflater ;
   private ArrayList<HashMap<String,Object>> listItemData ;

    //构造函数，传入数据
    public MyAdapter(Context context, ArrayList<HashMap<String, Object>> listItem) {
        layoutInflater = LayoutInflater.from(context);
        this.listItemData = listItem;
    }


    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new Viewholder(layoutInflater.inflate(R.layout.rl_item,null));
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        Viewholder vh = holder ;
        // 绑定数据到ViewHolder里面
        vh.Title.setText((String) listItemData.get(position).get("ItemTitle"));
        vh.Text.setText((String) listItemData.get(position).get("ItemText"));
    }

    @Override
    public int getItemCount() {
        return listItemData.size();
    }

    static class Viewholder extends RecyclerView.ViewHolder{

        private TextView Title, Text;

        public Viewholder(View root) {
            super(root);
            Title = root.findViewById(R.id.Itemtitle);
            Text =  root.findViewById(R.id.Itemtext);

        }

        public TextView getTitle() {
            return Title;
        }

        public TextView getText() {
            return Text;
        }

    }
}
