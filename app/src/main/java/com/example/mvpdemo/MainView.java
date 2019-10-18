package com.example.mvpdemo;

import android.widget.TextView;

public interface MainView {

interface MessageUpdateListener{
    void onMessageUpdate(TextView textView);
}

    void showProgress();
    void hideProgress();
    void updateQuote(String quote);
    void setUpdateListener(MessageUpdateListener listener);

}
