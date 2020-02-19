package com.wd.doctor.base;

import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected P mPresenters;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutIds());
        mUnbinder = ButterKnife.bind(this);
        mPresenters = providePresenter();
        if (mPresenters != null) {
            mPresenters.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P providePresenter();


    protected abstract int provideLayoutIds();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        if (mPresenters != null) {
            mPresenters.detachView();
        }
    }

}
