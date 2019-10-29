package com.example.mvpdemo.fragment;

import android.view.View;
import android.widget.Button;

public interface Fragment2Presenter {

    void onButtonClick();
    void updateMessage(String msg);
    View getRootView();
    void onDestroy();
}
