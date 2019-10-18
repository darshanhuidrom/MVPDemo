package com.example.mvpdemo.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdemo.MainView;
import com.example.mvpdemo.R;
import com.example.mvpdemo.search.ViewMvpSearch;
import com.example.mvpdemo.search.ViewMvpSearchImpl;
import com.example.mvpdemo.fragment.FragmentHandler;
import com.example.mvpdemo.fragment.FragmentHandlerImpl;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    FragmentHandler fragmentHandler;
    ViewMvpSearch viewMvpSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentHandler = new FragmentHandlerImpl(this);
        viewMvpSearch= new ViewMvpSearchImpl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fragmentHandler.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        viewMvpSearch.addSearchBar(menu.findItem(R.id.action_search));

        viewMvpSearch.setSearchListener(new ViewMvpSearch.SearchListener() {
            @Override
            public void onCompleted(final String s) {
                fragmentHandler.setListener(new MainView.MessageUpdateListener() {
                    @Override
                    public void onMessageUpdate(TextView textView) {
                        textView.setText(s);
                    }
                });
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        item.setChecked(true);
        switch (id) {
            case R.id._1:

                break;
            case R.id._2:

                break;
            case R.id._3:
                break;
            case R.id._4:
                break;
            case R.id._5:
                break;
            case R.id._6:
                break;


        }
        Toast.makeText(getApplicationContext(), item.getTitle() + " is selected", Toast.LENGTH_SHORT).show();
        item.setChecked(true);
        return true;

    }
}
