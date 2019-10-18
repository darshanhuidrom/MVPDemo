package com.example.mvpdemo.fragment;

import android.content.Context;

import com.example.mvpdemo.MainView;
import com.example.mvpdemo.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FragmentHandlerImpl implements FragmentHandler{

    private Fragment fragment;
    private Context context;

    public FragmentHandlerImpl(Context context){
        this.context=context;
        addFragments();

    }



    private void addFragments(){
        fragment = new Fragment1();
        ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction()
                .add(R.id.container,fragment,"1").commit();
    }


    @Override
    public void onDestroy() {
        fragment=null;
        context=null;
    }

    @Override
    public void setListener(MainView.MessageUpdateListener listener) {
        ((MainView) fragment).setUpdateListener(listener);
    }
}
