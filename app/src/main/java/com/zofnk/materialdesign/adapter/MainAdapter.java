package com.zofnk.materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zofnk.materialdesign.R;


/**
 * Created by Administrator on 2017/3/28.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.VH> {

    private Context mContext;
    private OnItemClickListence l;

    public MainAdapter(Context context) {
        mContext = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainAdapter.VH(LayoutInflater.from(mContext).inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {
       if (l != null){
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   l.setOnclickListence(view , position);
               }
           });
       }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public void setOnItemClickListence(OnItemClickListence l) {
        this.l = l;
    }

    public interface OnItemClickListence {
        void setOnclickListence(View view, int position);
    }

    class VH extends RecyclerView.ViewHolder {

        public VH(View itemView) {
            super(itemView);
        }
    }
}
