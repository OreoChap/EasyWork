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
    private List<T> mData;
    private int mLayout;
    private OnViewHolderClickListener mListener;

    public BaseRecyclerAdapter(Context context, List<T> list, @IdRes int layoutId,
                               @Nullable OnViewHolderClickListener listener){
        this.mData = list;
        this.mLayout = layoutId;
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return BaseViewHolder.
                createViewHolder(mContext, parent, mLayout, mData, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        final int mPosition = position;
        bindHolder(holder, mData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick(mPosition);
                }
            }
        });
    }

    public abstract void bindHolder(BaseViewHolder holder, T item);

    public void setOnViewHolderClickListener(OnViewHolderClickListener listener) {
        this.mListener = listener;
    }

    public interface OnViewHolderClickListener {
        void onClick(int viewHolderPosition);
    }
}
