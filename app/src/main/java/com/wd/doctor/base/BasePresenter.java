package com.wd.doctor.base;

import android.content.Context;


import java.lang.ref.WeakReference;


public abstract class BasePresenter<V extends BaseActivity> {

    public V v;

    public void attachViews(V t) {
        this.v = t;
    }

    public void unAttachViews() {
        if (v != null) {
            v = null;
        }
    }

}
