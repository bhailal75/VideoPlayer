package com.xodec.videoplayer.adpter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.xodec.videoplayer.R;
import com.xodec.videoplayer.databinding.RowHomeBinding;
import com.xodec.videoplayer.model.Datum;

import java.util.ArrayList;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
    private RowHomeBinding mBinding;
    private HomeInterface homeInterface;
    private ArrayList<Datum> arrayList;
    public HomeAdapter(FragmentActivity activity, ArrayList<Datum> arrayList,HomeInterface homeInterface) {
        this.context = activity;
        this.arrayList = arrayList;
        this.homeInterface = homeInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_home, parent, false);
        return new ViewHolder(mBinding, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(arrayList.get(position).getImage()).into(mBinding.imgVideo);
        holder.mBinding.imgVideo.setTag(position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RowHomeBinding mBinding;

        public ViewHolder(RowHomeBinding mBinding, View itemView) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
            this.mBinding.imgVideo.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v == mBinding.imgVideo) {
                if (homeInterface != null) {
                    int pos = (int) v.getTag();
                    homeInterface.onVideoClick(pos);
                }
            }
        }
    }

    public interface HomeInterface{
        void onVideoClick(int pos);
    }
}
