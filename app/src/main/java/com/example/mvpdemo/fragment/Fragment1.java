package com.example.mvpdemo.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mvpdemo.activity.MainPresenter;
import com.example.mvpdemo.activity.MainPresenterImpl;
import com.example.mvpdemo.MainView;
import com.example.mvpdemo.model.QuoteProviderImpl;
import com.example.mvpdemo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements MainView {


    private View view;
    private Button button;
    private TextView textView,textView2;
    private ProgressBar progressBar;
    private MainPresenter presenter;


    public Fragment1() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_fragment1, container, false);
        presenter = new MainPresenterImpl(this,new QuoteProviderImpl());
        initViews(view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonClick();
            }
        });
        return view;
    }

    private void initViews(View view) {
        textView=view.findViewById(R.id.textView);
        textView2=view.findViewById(R.id.textView2);
        button=view.findViewById(R.id.button);
        progressBar=view.findViewById(R.id.progressBar);
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void updateQuote(String quote) {

        textView.setText(quote);
    }

    @Override
    public void setUpdateListener(MessageUpdateListener listener) {
        listener.onMessageUpdate(textView2);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }


}
