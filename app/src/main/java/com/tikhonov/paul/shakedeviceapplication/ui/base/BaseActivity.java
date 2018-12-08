package com.tikhonov.paul.shakedeviceapplication.ui.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.tikhonov.paul.shakedeviceapplication.R;

@SuppressLint("Registered")
public class BaseActivity extends MvpAppCompatActivity implements BaseView {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_icon);
    }

    // TODO Create dialog
    private void error(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG);
    }
}
