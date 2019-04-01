package com.oreooo.library.ListBase;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{

    private Context mContext;
    private List<T> mDatas;
    private int mLayout;
    private OnItemClickListener mListener;

    public BaseRecyclerAdapter(Context context, List<T> list, @IdRes int layoutId,
                               @Nullable OnItemClickListener listener){
        this.mDatas = list;
        this.mLayout = layoutId;
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return BaseViewHolder.
                createViewHolder(mContext, parent, mLayout, mDatas, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        final int mPosition = position;
        bindHolder(holder, mDatas.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.OnItemClick(mPosition);
            }
        });
    }

    public abstract void bindHolder(BaseViewHolder holder, T item);

    // 更新 mListener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnItemClickListener {
        void OnItemClick(int taskId);
    }
}
