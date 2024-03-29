package com.example.mvpdemo.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdemo.MainView;
import com.example.mvpdemo.R;
import com.example.mvpdemo.fragment.Fragment3;
import com.example.mvpdemo.fragment.FragmentHandler;
import com.example.mvpdemo.search.ViewMvpSearch;
import com.example.mvpdemo.search.ViewMvpSearchImpl;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Fragment3.OnFragmentInteractionListener {

    FragmentHandler fragmentHandler;
    ViewMvpSearch viewMvpSearch;
    private  MainActivityPresenterImpl mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        ProviderPresenter providerPresenter = new ProviderPresenterImpl(getApplicationContext());
       // providerPresenter.deleteStudentByName("Huidrom");
        providerPresenter.update("1","Huidrom","H");
        providerPresenter.onRetrieveStudents();

      //  fragmentHandler = new FragmentHandlerImpl(this);
      //  mainActivityPresenter=new MainActivityPresenterImpl(this,null);
     //   setContentView(mainActivityPresenter.getRootView());
     //   viewMvpSearch= new ViewMvpSearchImpl(this);


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  fragmentHandler.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        viewMvpSearch.addSearchBar(menu.findItem(R.id.action_search));

        viewMvpSearch.setSearchListener(new ViewMvpSearch.SearchListener() {
            @Override
            public void onCompleted(final String s) {
                mainActivityPresenter.setListener(new MainView.MessageUpdateListener() {
                    @Override
                    public void onMessageUpdate(TextView textView) {
                        if(textView==null){
                            Toast.makeText(getApplicationContext(),"textview is null",Toast.LENGTH_SHORT).show();
                            return;
                        }
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


    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(getApplicationContext(),"Hi,this is Fragment3",Toast.LENGTH_SHORT).show();
    }


}
