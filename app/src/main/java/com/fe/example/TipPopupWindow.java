package com.fe.example;

import android.content.Context;
import android.view.View;
import com.free.universaldialog.base.AbsCustomPopupWindow;

/**
 * Created by lenovo on 2017/5/5.
 */
public class TipPopupWindow extends AbsCustomPopupWindow {

    public TipPopupWindow(Context context) {
        inflaterView(context, R.layout.dialog_add);
    }

    @Override
    protected void initView(View contentView) {

    }
}
