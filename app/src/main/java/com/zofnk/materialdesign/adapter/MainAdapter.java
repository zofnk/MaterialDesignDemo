package com.zofnk.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zofnk.materialdesign.entity.DataResponse;
import com.zofnk.materialdesign.OnItemClickListener;
import com.zofnk.materialdesign.R;
import com.zofnk.materialdesign.activity.MainActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/28.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.VH> {

    private Context mContext;
    private OnItemClickListener l;
    private List<DataResponse.ShowapiResBodyBean.PagebeanBean.ContentlistBean> mContentlist;

    public MainAdapter(Context context) {
        mContext = context;
    }

    public MainAdapter(Context context, List<DataResponse.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlistdatas) {
        mContext = context;
        mContentlist = contentlistdatas;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainAdapter.VH(LayoutInflater.from(mContext).inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {
        if (mContext instanceof MainActivity) {
            holder.mTvTitle.setText(!TextUtils.isEmpty(mContentlist.get(position).getTitle()) ?
                    mContentlist.get(position).getTitle() : "暂无数据");
        }
        if (l != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    l.setOnclickListence(view, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mContext instanceof MainActivity ? mContentlist.size() : 20;
    }

    public void setOnItemClickListence(OnItemClickListener l) {
        this.l = l;
    }

    class VH extends RecyclerView.ViewHolder {

        @Bind(R.id.tvTitle)
        TextView mTvTitle;
        @Bind(R.id.imgMain)
        ImageView mImgMain;

        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
