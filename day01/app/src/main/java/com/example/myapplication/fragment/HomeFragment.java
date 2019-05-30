package com.example.myapplication.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.activity.XiangActivity;
import com.example.myapplication.adapter.RlvHomeAdapter;
import com.example.myapplication.base.BaseMvpFragment;
import com.example.myapplication.bean.HomeBannerBean;
import com.example.myapplication.bean.HomeBean;
import com.example.myapplication.bean.MyDbBean;
import com.example.myapplication.model.HomeModel;
import com.example.myapplication.presenter.HomePresenter;
import com.example.myapplication.utils.MyDbUtils;
import com.example.myapplication.view.HomeView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseMvpFragment<HomePresenter, HomeModel, HomeView>
        implements HomeView, RlvHomeAdapter.DianJi, RlvHomeAdapter.ChangAn {


    @BindView(R.id.home_rlv)
    RecyclerView homeRlv;
    private ArrayList<HomeBean.DataBean.DatasBean> list;
    private ArrayList<HomeBannerBean.DataBean> banner;
    private RlvHomeAdapter adapter;

    @Override
    protected HomeView addView() {
        return this;
    }

    @Override
    protected HomeModel addModel() {
        return new HomeModel();
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        myPre.setData();
        myPre.initData();

    }

    @Override
    protected void initView(View inflate) {
        list = new ArrayList<>();
        banner = new ArrayList<>();
        adapter = new RlvHomeAdapter(getActivity(),banner,list);
        homeRlv.setAdapter(adapter);
        homeRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.setDianJi(this);
        adapter.setChangAn(this);
    }

    @Override
    public void shi(String str) {

    }

    @Override
    public void cheng(HomeBannerBean bean) {
        if (bean!=null&&bean.getData()!=null) {
            banner.addAll(bean.getData());
            adapter.setBanner(banner);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void sh(String str) {

    }

    @Override
    public void chen(HomeBean bean) {
        if (bean!=null&&bean.getData()!=null&&bean.getData().getDatas()!=null) {
            list.addAll(bean.getData().getDatas());
            adapter.setList(list);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void s(final String str) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void ch(final String s) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void jianTing(int position) {
        Intent intent = new Intent(getContext(), XiangActivity.class);
        intent.putExtra("name",list.get(position).getLink());
        startActivityForResult(intent,100);
    }

    @Override
    public void jian(int position) {
        HomeBean.DataBean.DatasBean datasBean = list.get(position);
        myPre.add(datasBean);
    }
}
