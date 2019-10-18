package com.example.mvpdemo.search;

import android.content.Context;
import android.view.MenuItem;

import androidx.appcompat.widget.SearchView;

public class ViewMvpSearchImpl implements ViewMvpSearch, SearchView.OnQueryTextListener {

    private Context context;
    private SearchView mSearchView;
    private SearchListener searchListener;

    public ViewMvpSearchImpl(Context context) {
        this.context = context;
    }

    @Override
    public void setSearchListener(SearchListener listener) {

        searchListener = listener;
    }

    @Override
    public void addSearchBar(MenuItem menuItem) {

        mSearchView = (SearchView) menuItem.getActionView();
        mSearchView.setIconified(true);
        mSearchView.setOnQueryTextListener(this);//Android SearchView listener
    }

    @Override
    public void onCloseSearch() {

        mSearchView.setQuery("", false);
        searchListener.onCompleted("");// Custom listener
        mSearchView.onActionViewCollapsed();

    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        searchListener.onCompleted(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        searchListener.onCompleted(newText);
        return true;
    }

}
