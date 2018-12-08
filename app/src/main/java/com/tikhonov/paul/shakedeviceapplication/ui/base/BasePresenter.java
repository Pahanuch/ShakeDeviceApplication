package com.tikhonov.paul.shakedeviceapplication.ui.base;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

public abstract class BasePresenter<View extends BaseView & MvpView> extends MvpPresenter<View> {

    // TODO
    protected void handleError(Throwable e) {

    }

}
