package com.free.universaldialog.base;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
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
        mPopupWindow =  new PopupWindow(universalDialog.context);
        mPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(universalDialog.canceledOnTouchOutside);
        mPopupWindow.setAnimationStyle(universalDialog.animation);
        mPopupWindow.setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setContentView(contentView);

        showLocation(universalDialog);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    protected void showLocation(UniversalDialog universalDialog) {
        if (universalDialog.showAsDropDown)
            mPopupWindow.showAsDropDown(universalDialog.anchorView);
        if (universalDialog.showAsDropDownXy) {
            mPopupWindow.showAsDropDown(universalDialog.anchorView, universalDialog.xoff, universalDialog.yoff);
        }
        if (universalDialog.showAsDropDownXyGravity) {
            mPopupWindow.showAsDropDown(universalDialog.anchorView, universalDialog.xoff, universalDialog.yoff, universalDialog.gravity);
        }
        if (universalDialog.showAtLocation)
            mPopupWindow.showAtLocation(universalDialog.parent, universalDialog.x, universalDialog.y, universalDialog.gravity);
    }
}
