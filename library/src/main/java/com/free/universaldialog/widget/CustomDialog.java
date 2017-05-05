package com.free.universaldialog.widget;


import com.free.universaldialog.UniversalDialog;
import com.free.universaldialog.base.AbsDialog;
import com.free.universaldialog.base.ICustomDialog;

/**
 * Created by chenpengfei on 2017/5/5.
 */
public class CustomDialog extends AbsDialog {

    @Override
    public void show(UniversalDialog universalDialog) {
        ICustomDialog customDialog = universalDialog.customDialog;
        if (customDialog == null) return;

        initDialog(universalDialog, customDialog.getContentView());
    }

    @Override
    public void cancel() {

    }
}
