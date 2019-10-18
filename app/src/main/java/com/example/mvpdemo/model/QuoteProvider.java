package com.example.mvpdemo.model;

public interface QuoteProvider {

    interface OnFinishListener{
        void onFinish(String quote);
    }
    void getNextQuote(OnFinishListener listener);
}
