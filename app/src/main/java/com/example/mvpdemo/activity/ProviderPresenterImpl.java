package com.example.mvpdemo.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.mvpdemo.R;
import com.example.mvpdemo.StudentProvider;

public class ProviderPresenterImpl implements ProviderPresenter {


    static final String TAG = ">>>>>>>>";
    View mRootView;
    Context context;


    public ProviderPresenterImpl(Context context) {

        mRootView = LayoutInflater.from(context).inflate(R.layout.test_activity, null);
        this.context = context;

    }

    @Override
    public void onAddName(String name, String grade) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(StudentProvider.NAME, name);
        contentValues.put(StudentProvider.GRADE, grade);
        Uri uri = context.getContentResolver().insert(StudentProvider.CONTENT_URI, contentValues);
        Log.d(TAG, uri.toString());
    }

    @Override
    public void onRetrieveStudents() {

        String[] projection = new String[]{StudentProvider._ID, StudentProvider.NAME, StudentProvider.GRADE};
        Cursor cursor = context.getContentResolver().query(StudentProvider.CONTENT_URI, projection, null, null, StudentProvider._ID);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {

                    Log.d(TAG, cursor.getString(cursor.getColumnIndex(StudentProvider._ID))
                            + "," + cursor.getString(cursor.getColumnIndex(StudentProvider.NAME)) + "," +
                            cursor.getString(cursor.getColumnIndex(StudentProvider.GRADE)));
                }
                while (cursor.moveToNext());
            }
        }

    }

    @Override
    public void deleteStudentByName(String name) {
        String[] selectArg = {name};
        String where = "name =?";
        int count = 0;
        count = context.getContentResolver().delete(StudentProvider.CONTENT_URI, where, selectArg);
        Log.d(TAG, count + "rows deleted");
    }

    @Override
    public void update(String id, String name, String grade) {
        ContentValues values = new ContentValues();
        values.put(StudentProvider.NAME, name);
        values.put(StudentProvider.GRADE, grade);
        String where = "_id=?";
        String[] selecArg = {id};
        int count = 0;
        count = context.getContentResolver().update(StudentProvider.CONTENT_URI, values, where, selecArg);
        Log.d(TAG,count+" row is updated");
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void onDestroy() {
        mRootView = null;
    }
}
