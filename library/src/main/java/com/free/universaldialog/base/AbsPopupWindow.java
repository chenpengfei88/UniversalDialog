package com.free.universaldialog.base;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.free.universaldialog.UniversalDialog;

/**
 * Created by chenpengfei on 2017/3/24.
 */
public abstract class AbsPopupWindow implements IDialog {

    protected PopupWindow mPopupWindow;

    protected void initPopupWindow(UniversalDialog universalDialog, View contentView) {
        mPopupWindow = new PopupWindow(universalDialog.context);
        mPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(universalDialog.canceledOnTouchOutside);
        mPopupWindow.setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setContentView(contentView);

        showLocation(universalDialog);
    }

    protected void showLocation(UniversalDialog universalDialog) {
        mPopupWindow.showAsDropDown(universalDialog.anchorView);
    }
}
