package com.oreooo.library.MvpBase;

import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;

import com.oreooo.library.R;


public class BaseActivity extends AppCompatActivity {

    private int MenuID;

    public void initToolBar(Toolbar toolbar) {
        if (null == toolbar)return;
        initToolBar(toolbar, R.string.app_name);
    }

    public void initToolBar(Toolbar toolbar, @StringRes int title) {
        if (null == toolbar)return;
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void initToolBar(Toolbar toolbar, String title) {
        if (null == toolbar)return;
        toolbar.setTitle(title);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void initToolBarNoNavigation(Toolbar toolbar, @Nullable String title) {
        if (null == toolbar)return;
        if (!TextUtils.isEmpty(title)) toolbar.setTitle(title);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (MenuID != 0) {
            getMenuInflater().inflate(MenuID, menu);
        }
        return true;
    }

    public void setMenu(@MenuRes int MenuId) {
        this.MenuID = MenuId;
    }
}
