package com.example.zhanggang.recyclerviewdemo830;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 类作用：recyclerview适配器
 * 时  间：2017/8/30 - 20:00.
 * 创建人：张刚
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list;
    private Context context;

    public MyAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载布局
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder mholder = (ViewHolder) holder;
            ((ViewHolder) holder).textView.setText(list.get(position));
            //添加属性动画
            //沿X轴平移
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mholder.textView, "translationX", 0, -100f, 100f, 0f);
            objectAnimator.setDuration(2000);
            objectAnimator.start();
            //渐变
            ObjectAnimator objectAnimator1 = objectAnimator.ofFloat(mholder.imageView, "alpha", 1f, 0f, 1f);
            objectAnimator1.setDuration(2000);
            objectAnimator1.start();

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
