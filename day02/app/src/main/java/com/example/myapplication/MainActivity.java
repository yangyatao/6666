package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rlv;
    private MyAdapter adapter;
    private ArrayList<MyDbBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        ArrayList<MyDbBean> cha = MyDbUtils.getMyDbUtils().cha();
        list.addAll(cha);
        adapter.setList(list);
        adapter.notifyDataSetChanged();

    }

    private void initView() {
        rlv = (RecyclerView) findViewById(R.id.rlv);
        list = new ArrayList<>();
        adapter = new MyAdapter(list,this);
        rlv.setAdapter(adapter);
        rlv.setLayoutManager(new LinearLayoutManager(this));

    }
}
