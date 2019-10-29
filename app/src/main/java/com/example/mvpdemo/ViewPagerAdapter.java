package com.example.mvpdemo;

import android.content.Context;

import com.example.mvpdemo.fragment.Fragment1;
import com.example.mvpdemo.fragment.Fragment2;
import com.example.mvpdemo.fragment.Fragment3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private CharSequence[] mTitle;
    private MainView.MessageUpdateListener listener;
    private Fragment fragment;


    public ViewPagerAdapter(FragmentManager fm, CharSequence[] mTitles) {
        super(fm);
        this.mTitle = mTitles;
    }

    public void setListener(MainView.MessageUpdateListener listener) {
        if(fragment!=null)
        ((Fragment1) fragment).setUpdateListener(listener);
    }


    @Override
    public int getCount() {
        return mTitle.length;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment tempFrag=null;
        switch (position) {

            case 0:
                fragment =tempFrag = new Fragment1();
                break;
            case 1:
                tempFrag = new Fragment2();
                break;
            case 2:
                tempFrag = new Fragment3();
                break;
        }
        return tempFrag;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }


}
