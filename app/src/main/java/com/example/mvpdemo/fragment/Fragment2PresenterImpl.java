package com.example.mvpdemo.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdemo.R;

import java.util.zip.Inflater;

public class Fragment2PresenterImpl implements Fragment2Presenter {


    private Context context;
    private View view;
    private TextView textView;
    private EditText editText;
    private Button button;
    public Fragment2PresenterImpl(Context context){
        this.context=context;
        this.view = LayoutInflater.from(context).inflate(R.layout.fragment_fragment2,null,false);
        textView = view.findViewById(R.id.textView);
        editText = view.findViewById(R.id.inputText);
        button = view.findViewById(R.id.button);
    }

    @Override
    public void onButtonClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Button Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void updateMessage(String msg) {
        textView.setText(msg);
    }

    @Override
    public View getRootView() {
        return this.view;
    }

    @Override
    public void onDestroy() {
        textView = null;
        editText = null;
        button = null;
        view=null;
    }
}
