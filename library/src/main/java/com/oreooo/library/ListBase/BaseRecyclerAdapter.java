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
    private int mLayoutId;
    private OnViewHolderClickListener mListener;

    // 头尾ViewHolder实例
    View mHeaderView;
    View mFooterView;
    private static final int TYPE_HEADER = 0;  //说明是带有Header的
    private static final int TYPE_FOOTER = 1;  //说明是带有Footer的
    private static final int TYPE_NORMAL = 2;  //说明是不带有header和footer的

    public BaseRecyclerAdapter(Context context, List<T> list, @IdRes int layoutId,
                               @Nullable OnViewHolderClickListener listener){
        this.mData = list;
        this.mLayoutId = layoutId;
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public int getItemCount() {
        if(mHeaderView == null && mFooterView == null){
            return mData.size();
        }else if(mHeaderView == null || mFooterView == null){
            return mData.size() + 1;
        }else {
            return mData.size() + 2;
        }
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return BaseViewHolder.
                createViewHolder(mContext, parent, mLayoutId, mData, mListener);
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

    abstract void bindHolder(BaseViewHolder holder, T item);

    public void setOnViewHolderClickListener(OnViewHolderClickListener listener) {
        this.mListener = listener;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public void setFooterView(View footerView) {
        mFooterView = footerView;
        notifyItemInserted(getItemCount()-1);
    }

    public interface OnViewHolderClickListener {
        void onClick(int viewHolderPosition);
    }
}
