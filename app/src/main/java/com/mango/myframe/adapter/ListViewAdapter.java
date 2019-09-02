package com.mango.myframe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import java.util.List;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/08/12.
 */
public class ListViewAdapter<T> extends BaseAdapter {

    private Context mContext;
    private List<T> mList;
    private int mLayoutId;
    private int mVariableId;


    public ListViewAdapter(Context context, List<T> list, int layoutId, int variableId){
        mContext = context;
        mList = list;
        mLayoutId = layoutId;
        mVariableId = variableId;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewDataBinding dataBinding;
        if(view == null){
            dataBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), mLayoutId, viewGroup, false);
        }else {
            dataBinding = DataBindingUtil.getBinding(view);
        }
        dataBinding.setVariable(mVariableId, mList.get(i));
        return dataBinding.getRoot();
    }
}
