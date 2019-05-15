package com.oreooo.library.MvpBase;

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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(setContentView(), container, false);
        initView(view, savedInstanceState);
        return view;
    }

    public abstract void initView(View view, Bundle savedInstanceState);

    public abstract int setContentView();
}
