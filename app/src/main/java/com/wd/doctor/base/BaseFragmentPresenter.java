package com.wd.doctor.base;

import java.lang.ref.WeakReference;


public abstract class BaseFragmentPresenter<V extends BaseFragment> {

    private WeakReference<V> mWeakReference;

    protected void attachView(V v) {
        mWeakReference = new WeakReference<>(v);
    }

    protected void detachView() {
        if (mWeakReference != null) {
            mWeakReference.clear();
            mWeakReference = null;
        }
    }

    protected boolean isViewAttached() {
        if (mWeakReference == null || mWeakReference.get() == null) {
            return false;
        }
        return true;
    }

}
