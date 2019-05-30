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
import com.example.myapplication.bean.HomeBean;
import com.example.myapplication.bean.HomeBannerBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;


public class RlvHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<HomeBannerBean.DataBean> banner;
    private ArrayList<HomeBean.DataBean.DatasBean> list;

    public RlvHomeAdapter(Context context, ArrayList<HomeBannerBean.DataBean> bannerList,
                          ArrayList<HomeBean.DataBean.DatasBean> articleList) {
        this.context = context;
        this.banner = bannerList;
        this.list = articleList;
    }

    public void setBanner(ArrayList<HomeBannerBean.DataBean> banner) {
        this.banner = banner;
    }

    public void setList(ArrayList<HomeBean.DataBean.DatasBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;

        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_banner, null);
            viewHolder = new BannerView(inflate);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_list, null);
            viewHolder = new lisView(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerView) {
            BannerView bannerView = (BannerView) holder;


            bannerView.banner.setImages(banner);
            bannerView.banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    HomeBannerBean.DataBean dataBean = (HomeBannerBean.DataBean) path;
                    Glide.with(context).load(dataBean.getImagePath()).into(imageView);
                }
            });
            bannerView.banner.start();
        } else if (holder instanceof lisView) {
            lisView lisView = (lisView) holder;

            int newPosition = position;
            if (banner.size() > 0) {
                newPosition = position - 1;
            }

            final HomeBean.DataBean.DatasBean datasBean = list.get(newPosition);
            lisView.time.setText(datasBean.getAuthor());
            lisView.title.setText(datasBean.getSuperChapterName());
            lisView.name.setText(datasBean.getTitle());
            Glide.with(context).load(datasBean.getEnvelopePic()).into(lisView.img);

            final int finalNewPosition = newPosition;
            lisView.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dianJi!=null) {
                        dianJi.jianTing(finalNewPosition);
                    }
                }
            });
            lisView.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (changAn!=null) {
                        changAn.jian(finalNewPosition);
                    }
                    return false;
                }
            });
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        if (banner.size() > 0) {
            return list.size() + 1;
        } else {
            return list.size();
        }
    }

    class BannerView extends RecyclerView.ViewHolder {

        private Banner banner;

        public BannerView(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
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

    public interface DianJi{
        void jianTing(int position);
    }
    private ChangAn changAn;

    public void setChangAn(ChangAn changAn) {
        this.changAn = changAn;
    }

    public interface ChangAn{
        void jian(int position);
    }
}
