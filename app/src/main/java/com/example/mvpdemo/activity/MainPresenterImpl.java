package com.example.mvpdemo.activity;

import android.view.View;

import com.example.mvpdemo.MainView;
import com.example.mvpdemo.model.QuoteProvider;

public class MainPresenterImpl implements MainPresenter {
    private MainView mainView;
    private QuoteProvider quoteProvider;

    public MainPresenterImpl(MainView mainView,QuoteProvider quoteProvider){
        this.mainView=mainView;
        this.quoteProvider=quoteProvider;
    }
    @Override
    public void onButtonClick() {
        if(mainView!=null) {
            mainView.showProgress();
            quoteProvider.getNextQuote(new QuoteProvider.OnFinishListener() {
                @Override
                public void onFinish(String quote) {
                    mainView.hideProgress();
                    mainView.updateQuote(quote);
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        mainView=null;
    }

    @Override
    public View getRootView() {
        return null;
    }
}
