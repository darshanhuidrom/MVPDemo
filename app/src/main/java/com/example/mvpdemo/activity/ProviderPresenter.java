package com.example.mvpdemo.activity;

import android.view.View;

public interface ProviderPresenter {
    void onAddName(String name,String grade);
    void onRetrieveStudents();
    void deleteStudentByName(String name);
    void update(String id,String name,String grade);
    View getRootView();
    void onDestroy();
}
