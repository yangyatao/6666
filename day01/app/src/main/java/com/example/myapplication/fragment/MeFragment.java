package com.example.myapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.activity.CollectActivity;
import com.example.myapplication.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends BaseFragment {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.bt)
    Button bt;

    @Override
    protected int initLayout() {
        return R.layout.fragment_me;
    }


    @OnClick({R.id.img, R.id.tv, R.id.tv2, R.id.bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img:
                break;
            case R.id.tv:
                break;
            case R.id.tv2:
                Intent intent = new Intent(getActivity(), CollectActivity.class);
                startActivity(intent);
                break;
            case R.id.bt:
                break;
        }
    }
}
