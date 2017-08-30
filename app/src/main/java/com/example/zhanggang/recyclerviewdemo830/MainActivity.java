package com.example.zhanggang.recyclerviewdemo830;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);

        init();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //添加分割线
        recyclerView.addItemDecoration(new MyLine(this,R.drawable.shape));

        MyAdapter adapter = new MyAdapter(list,this);
        recyclerView.setAdapter(adapter);

    }

    private void init() {
        list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("第 "+i+" 条");
        }
    }


}
