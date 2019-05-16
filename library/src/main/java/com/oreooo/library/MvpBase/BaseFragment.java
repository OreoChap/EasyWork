package com.oreooo.library.MvpBase;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *   如果重写了onCreateView()，子类需要调用super.onCreateView()，才能使initView()，initListener() 正常运作
 */
public abstract class BaseFragment extends Fragment {
    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(setContentView(), container, false);
        initView(view, savedInstanceState);
        return view;
    }

    public abstract void initView(View view, Bundle savedInstanceState);

    public abstract int setContentView();

    protected Context getMyContext() {
        return context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        context = null;
    }
}
