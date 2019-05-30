package com.example.app3;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.app3.adapter.MyAdapter;
import com.example.app3.bean.MyBean;
import com.example.app3.model.MyModelImpl;
import com.example.app3.presenter.MyPresenterImpl;
import com.example.app3.view.MyView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyView {

    private RecyclerView rlv;
    private ArrayList<MyBean.DataBeanX.AladdinBean> list;
    private MyAdapter adapter;
    private MyPresenterImpl myPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        myPresenter = new MyPresenterImpl(new MyModelImpl(), this);
        myPresenter.getData();
    }

    private void initView() {
        rlv = (RecyclerView) findViewById(R.id.rlv);
        list = new ArrayList<>();
        adapter = new MyAdapter(list,this);
        rlv.setAdapter(adapter);
        rlv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void cheng(MyBean bean) {
        if (bean!=null&&bean.getData()!=null&&bean.getData().getAladdin()!=null) {
            list.add(bean.getData().getAladdin());
            adapter.setList(list);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void shi(String str) {

    }
}
