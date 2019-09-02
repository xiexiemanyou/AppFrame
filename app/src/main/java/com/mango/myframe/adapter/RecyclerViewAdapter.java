package com.mango.myframe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/08/13.
 */
public class RecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewAdapter.RecycleVH> {

    private List<T> mItemDataList = new ArrayList<>();
    private int mItemLayout;
    private int mVariableId;

    public RecyclerViewAdapter(List<T> itemDatas, int itemLayout, int variableId){
        mItemDataList = itemDatas;
        mItemLayout = itemLayout;
        mVariableId = variableId;
    }

    public void addListener(View root, T itemData, int position){

    }

    public void onItemDatasChanged(List<T> newItemDataList){
        mItemDataList = newItemDataList;
        notifyDataSetChanged();
    }

    public int getItemLayout(T itemData){
        return mItemLayout;
    }

    @Override
    public int getItemViewType(int position) {
        return getItemLayout(mItemDataList.get(position));
    }

    @NonNull
    @Override
    public RecycleVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
        return new RecycleVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleVH holder, int position) {
        holder.dataBinding.setVariable(mVariableId, mItemDataList.get(position));
        addListener(holder.dataBinding.getRoot(), mItemDataList.get(position), position);
        holder.dataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mItemDataList == null ? 0 : mItemDataList.size();
    }

    static class RecycleVH extends  RecyclerView.ViewHolder{

        ViewDataBinding dataBinding;

        RecycleVH(ViewDataBinding dataBinding){
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }
    }
}

