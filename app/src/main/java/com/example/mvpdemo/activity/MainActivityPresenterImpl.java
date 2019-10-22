package com.example.mvpdemo.activity;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.mvpdemo.MainView;
import com.example.mvpdemo.R;
import com.example.mvpdemo.ViewPagerAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class MainActivityPresenterImpl implements MainPresenter, TabLayout.OnTabSelectedListener {

    private Toolbar mToolBar;
    private TabLayout mTabLayout;
    private View mRootView;
    private Context mContext;
    private ViewPager mViewPager;
    private Window mWindow;
    private AppBarLayout mAppBarLayout;
    private MainView.MessageUpdateListener listener;
    private ViewPagerAdapter adapter;

    public MainActivityPresenterImpl(Context context, ViewGroup container) {

        this.mContext = context;
        mRootView = LayoutInflater.from(mContext).inflate(R.layout.activity_main, container);
        configViewSettings();

    }

    public void setListener(MainView.MessageUpdateListener listener){
       if (adapter!=null){
           adapter.setListener(listener);
       }
    }
    private void configViewSettings() {
        AppCompatActivity appCompatActivity = (AppCompatActivity) mContext;
        mWindow = appCompatActivity.getWindow();
        mToolBar = mRootView.findViewById(R.id.tool_bar);
        mTabLayout = mRootView.findViewById(R.id.tablayout);
        mViewPager = mRootView.findViewById(R.id.viewpager);
        mAppBarLayout=mRootView.findViewById(R.id.appBarLayout);

        CharSequence[] titles =
                {mContext.getResources().getString(R.string.folder_tab_name),
                        mContext.getResources().getString(R.string.list_tab_name),
                        mContext.getResources().getString(R.string.saved_tab_name),
                };

         adapter = new ViewPagerAdapter(appCompatActivity.getSupportFragmentManager(), titles);

        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            mTabLayout.addOnTabSelectedListener(this);
        appCompatActivity.setSupportActionBar(mToolBar);
        appCompatActivity.getSupportActionBar().setTitle("Demo App");

    }


    @Override
    public void onButtonClick() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        switch (tab.getPosition()) {
            case 0:
                mAppBarLayout.setBackgroundResource(R.color.black_dialog_header);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    mWindow.setStatusBarColor(mContext.getResources().getColor(R.color.transparent_black));
                break;
            case 1:
                mAppBarLayout.setBackgroundResource(R.color.colorPrimary);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    mWindow.setStatusBarColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
                break;

            case 2:
                mAppBarLayout.setBackgroundResource(R.color.primary);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    mWindow.setStatusBarColor(mContext.getResources().getColor(R.color.primaryDark));
                break;

            default:
                mAppBarLayout.setBackgroundResource(R.color.black_dialog_header);
        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
