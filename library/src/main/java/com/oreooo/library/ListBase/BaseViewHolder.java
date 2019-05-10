package com.oreooo.library.ListBase;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class BaseViewHolder extends RecyclerView.ViewHolder{

    private SparseArray<View> mViews;
    private Context mContext;
    private View mView;
    private List mData;
    private BaseRecyclerAdapter.OnViewHolderClickListener mListener;

    private BaseViewHolder(Context context, final View itemView, List data,
                           @Nullable BaseRecyclerAdapter.OnViewHolderClickListener listener){
        super(itemView);
        mViews = new SparseArray<>();
        this.mContext = context;
        this.mView = itemView;
        this.mData = data;
        this.mListener = listener;
    }

    public static BaseViewHolder createViewHolder(Context context, View itemView, List data,
             @Nullable BaseRecyclerAdapter.OnViewHolderClickListener listener) {
        return new BaseViewHolder(context, itemView, data, listener);
    }

    public static BaseViewHolder createViewHolder
            (Context context, ViewGroup parent, int layoutId, List data ,
             @Nullable BaseRecyclerAdapter.OnViewHolderClickListener listener) {
        return new BaseViewHolder(context, LayoutInflater.from(context).inflate
                (layoutId, parent, false), data, listener);
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T)view;
    }

    public void setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
    }
}
