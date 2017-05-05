package com.fe.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.free.universaldialog.base.ICustomDialog;

/**
 * Created by lenovo on 2017/5/5.
 */
public class TipDialog implements ICustomDialog {

    private View mContentView;

    public TipDialog(Context context) {
        mContentView = LayoutInflater.from(context).inflate(R.layout.dialog_tip, null);
    }

    @Override
    public View getContentView() {
        return mContentView;
    }
}
