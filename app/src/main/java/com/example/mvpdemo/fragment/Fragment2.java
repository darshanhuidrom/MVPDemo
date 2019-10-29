package com.example.mvpdemo.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvpdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    private TextView textView;
    private EditText editText;
    private Button button;
    private  Fragment2Presenter presenter;

    public Fragment2() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        presenter= new Fragment2PresenterImpl(getActivity());
        presenter.updateMessage("Hi how are u?");
        presenter.onButtonClick();
        return presenter.getRootView();
    }

}
