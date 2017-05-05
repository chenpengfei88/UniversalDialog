package com.free.universaldialog.widget;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.free.universaldialog.R;
import com.free.universaldialog.UniversalDialog;
import com.free.universaldialog.base.AbsPopupWindow;
import com.free.universaldialog.base.ICustomPopupWindow;

/**
 * Created by chenpengfei on 2017/5/5.
 */
public class CustomPopupWindow extends AbsPopupWindow {

    private LinearLayout rootLl;

    @Override
    public void show(UniversalDialog universalDialog) {
        ICustomPopupWindow customPopupWindow = universalDialog.customPopupWindow;
        if (customPopupWindow == null) return;

        View contentView = LayoutInflater.from(universalDialog.context).inflate(R.layout.popupwindow_select, null);
        rootLl = (LinearLayout) contentView.findViewById(R.id.ll_root);
        rootLl.getBackground().setAlpha(universalDialog.popupWindowAlpha);
        rootLl.addView(customPopupWindow.getContentView());

        initPopupWindow(universalDialog, contentView);
    }

    @Override
    public void cancel() {

    }
}
