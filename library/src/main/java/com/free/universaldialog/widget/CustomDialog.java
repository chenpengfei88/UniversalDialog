package com.free.universaldialog.widget;


import android.view.View;

import com.free.universaldialog.UniversalDialog;
import com.free.universaldialog.base.AbsDialog;
import com.free.universaldialog.base.AbsCustomDialog;

/**
 * Created by chenpengfei on 2017/5/5.
 */
public class CustomDialog extends AbsDialog {

    @Override
    public void show(final UniversalDialog universalDialog) {
        AbsCustomDialog customDialog = universalDialog.customDialog;
        if (customDialog == null) return;

        initDialog(universalDialog, customDialog.getContentView());

        View sureView = customDialog.getSureView();
        View cancelView = customDialog.getCancelView();
        if (sureView != null && (universalDialog.onSureClickListener != null || universalDialog.onSureCancelClickListener != null)) {
            sureView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (universalDialog.onSureClickListener != null) universalDialog.onSureClickListener.onSure(v);
                    if (universalDialog.onSureCancelClickListener != null) universalDialog.onSureCancelClickListener.onSure(v);

                    cancel();
                }
            });
        }

        if (cancelView != null && universalDialog.onSureCancelClickListener != null) {
            cancelView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    universalDialog.onSureCancelClickListener.onCancel(v);

                    cancel();
                }
            });
        }
    }


}
