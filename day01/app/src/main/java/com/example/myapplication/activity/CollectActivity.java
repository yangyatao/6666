package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.RlvCollectAdapter;
import com.example.myapplication.base.BaseMvpActivity;
import com.example.myapplication.bean.MyDbBean;
import com.example.myapplication.model.CollectModel;
import com.example.myapplication.presenter.CollectP;
import com.example.myapplication.view.CollectView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectActivity extends BaseMvpActivity<CollectP, CollectModel, CollectView>
        implements CollectView, RlvCollectAdapter.ChangAn, RlvCollectAdapter.DianJi {


    @BindView(R.id.collect_rlv)
    RecyclerView collectRlv;
    private ArrayList<MyDbBean> list;
    private RlvCollectAdapter adapter;
    private MyDbBean myDbBean;

    @Override
    protected int initLayout() {
        return R.layout.activity_collect;
    }

    @Override
    protected CollectView addView() {
        return this;
    }

    @Override
    protected CollectModel addModel() {
        return new CollectModel();
    }

    @Override
    protected CollectP initPresenter() {
        return new CollectP();
    }

    @Override
    protected void initData() {
        pre.setData();
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        adapter = new RlvCollectAdapter(this,list);
        collectRlv.setAdapter(adapter);
        collectRlv.setLayoutManager(new LinearLayoutManager(this));
        adapter.setChangAn(this);
        adapter.setDianJi(this);
    }

    @Override
    public void cheng(final ArrayList<MyDbBean> myDbBeans) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (myDbBeans!=null&&myDbBeans.size()>0) {
                    list.addAll(myDbBeans);
                    adapter.setList(list);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void shi(String str) {

    }

    @Override
    public void chen(final String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(CollectActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void sh(final String str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(CollectActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void jian(int position) {
        myDbBean = list.get(position);
        list.remove(position);
        adapter.notifyDataSetChanged();
        pre.initData(myDbBean);
    }

    @Override
    public void jianTing(int position) {
        Intent intent = new Intent(this, XiangActivity.class);
        intent.putExtra("name",list.get(position).getLink());
        startActivityForResult(intent,100);
    }
}
