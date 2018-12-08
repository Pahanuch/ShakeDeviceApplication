package com.tikhonov.paul.shakedeviceapplication.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tikhonov.paul.shakedeviceapplication.ui.base.BaseActivity;

abstract class MainBarActivity extends BaseActivity {

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }
}