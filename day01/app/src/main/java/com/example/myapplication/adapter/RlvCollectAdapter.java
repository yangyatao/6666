package com.example.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.HomeBannerBean;
import com.example.myapplication.bean.HomeBean;
import com.example.myapplication.bean.MyDbBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;


public class RlvCollectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<MyDbBean> list;

    public RlvCollectAdapter(Context context, ArrayList<MyDbBean> articleList) {
        this.context = context;
        this.list = articleList;
    }


    public void setList(ArrayList<MyDbBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, null);
        viewHolder = new lisView(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof lisView) {
            lisView lisView = (lisView) holder;
            final MyDbBean datasBean = list.get(position);
            lisView.time.setText(datasBean.getTime());
            lisView.title.setText(datasBean.getTitle());
            lisView.name.setText(datasBean.getName());
            Glide.with(context).load(datasBean.getImg()).into(lisView.img);

            lisView.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dianJi != null) {
                        dianJi.jianTing(position);
                    }
                }
            });
            lisView.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (changAn != null) {
                        changAn.jian(position);
                    }
                    return false;
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class lisView extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView title;
        private TextView time;
        private ImageView img;

        public lisView(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.list_name);
            title = itemView.findViewById(R.id.list_title);
            time = itemView.findViewById(R.id.list_time);
            img = itemView.findViewById(R.id.list_img);
        }
    }

    private DianJi dianJi;

    public void setDianJi(DianJi dianJi) {
        this.dianJi = dianJi;
    }

    public interface DianJi {
        void jianTing(int position);
    }

    private ChangAn changAn;

    public void setChangAn(ChangAn changAn) {
        this.changAn = changAn;
    }

    public interface ChangAn {
        void jian(int position);
    }
}
