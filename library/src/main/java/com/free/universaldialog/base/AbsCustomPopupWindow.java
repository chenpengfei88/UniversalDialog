package com.free.universaldialog.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by chenpengfei on 2017/5/5.
 */
public abstract class AbsCustomPopupWindow {

    protected View mContentView;

    protected void inflaterView(Context context, int resId) {
        mContentView = LayoutInflater.from(context).inflate(resId, null);
        initView(mContentView);
    }

    public View getContentView() {
        return mContentView;
    }

    protected abstract void initView(View contentView);
}
