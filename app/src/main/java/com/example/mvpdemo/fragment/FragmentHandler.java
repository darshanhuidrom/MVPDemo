package com.example.mvpdemo.fragment;

import com.example.mvpdemo.MainView;

public interface FragmentHandler {

    void onDestroy();
    void setListener(MainView.MessageUpdateListener listener);
}
