package com.example.mvpdemo.search;

import android.view.MenuItem;

public interface ViewMvpSearch {

    interface  SearchListener{
        void onCompleted(String s);
    }
    void setSearchListener(SearchListener listener);
    void addSearchBar(MenuItem menuItem);
    void onCloseSearch();
}
