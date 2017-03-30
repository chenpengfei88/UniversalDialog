package com.free.universaldialog.base;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.free.universaldialog.R;
import com.free.universaldialog.UniversalDialog;

/**
 * Created by chenpengfei on 2017/3/23.
 */
public abstract class AbsDialog implements IDialog {

    protected Dialog mDialog;

    protected void initDialog(UniversalDialog universalDialog, View contentView) {
        mDialog = new Dialog(universalDialog.context, R.style.dialog);
        mDialog.setContentView(contentView);
        mDialog.setCanceledOnTouchOutside(universalDialog.canceledOnTouchOutside);
        mDialog.setCancelable(universalDialog.cancelable);
        Window localWindow = mDialog.getWindow();
        if (universalDialog.animation != 0)
            localWindow.setWindowAnimations(universalDialog.animation);
        localWindow.setGravity(universalDialog.gravity);
        localWindow.setBackgroundDrawableResource(android.R.color.transparent);
        WindowManager.LayoutParams lp = localWindow.getAttributes();
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        localWindow.setAttributes(lp);

        if (mDialog != null && !mDialog.isShowing())
            mDialog.show();
    }
}
