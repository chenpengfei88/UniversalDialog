package com.free.universaldialog;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.View;
import com.free.universaldialog.base.IDialog;
import com.free.universaldialog.listener.OnItemClickListener;
import com.free.universaldialog.listener.OnSureCancelClickListener;
import com.free.universaldialog.widget.AlterDialog;
import com.free.universaldialog.widget.AlterSelectDialog;
import com.free.universaldialog.widget.SelectDialog;
import com.free.universaldialog.widget.SelectPopupWindow;

/**
 * Created by chenpengfei on 2017/3/30.
 */
public class UniversalDialog {

    public static final int DIALOG_ALTER_TYPE = 1;
    public static final int DIALOG_ALTER_SELECT_TYPE = 2;
    public static final int DIALOG_SELECT_TYPE = 3;
    public static final int POPUPWINDOW_SELECT_TYPE = 4;

    private IDialog dialog;
    public final Context context;

    public final String title;
    public final String[] itemArray;
    public final int titleColor;
    public final int titleSize;

    public final String message;
    public final int messageColor;
    public final int messageSize;

    public final String sureButton;
    public final int sureButtonSize;
    public final int sureButtonColor;

    public final String cancelButton;
    public final int cancelButtonSize;
    public final int cancelButtonColor;

    public final boolean cancelable;
    public final boolean canceledOnTouchOutside;
    public final int animation;
    public final View anchorView;
    public final View parent;
    public final int dialogType;
    public final int gravity;
    public final boolean showAsDropDown;
    public final boolean showAsDropDownXy;
    public final boolean showAsDropDownXyGravity;
    public final boolean showAtLocation;
    public final int xoff;
    public final int yoff;
    public final int x;
    public final int y;

    public final OnSureCancelClickListener onSureCancelClickListener;
    public final OnItemClickListener onItemClickListener;

    public UniversalDialog(Builder builder) {
        this.context = builder.context;

        this.title = builder.title;
        this.itemArray = builder.itemArray;
        this.titleSize = builder.titleSize;
        this.titleColor = builder.titleColor;

        this.message = builder.message;
        this.messageSize = builder.messageSize;
        this.messageColor = builder.messageColor;

        this.sureButton = builder.sureButton;
        this.sureButtonSize = builder.sureButtonSize;
        this.sureButtonColor = builder.sureButtonColor;

        this.cancelButton = builder.cancelButton;
        this.cancelButtonSize = builder.cancelButtonSize;
        this.cancelButtonColor = builder.cancelButtonColor;

        this.cancelable = builder.cancelable;
        this.canceledOnTouchOutside = builder.canceledOnTouchOutside;
        this.animation = builder.animation;
        this.anchorView = builder.anchorView;
        this.parent = builder.parent;
        this.dialogType = builder.dialogType;
        this.gravity = builder.gravity;
        this.showAsDropDown = builder.showAsDropDown;
        this.showAsDropDownXy = builder.showAsDropDownXy;
        this.showAsDropDownXyGravity = builder.showAsDropDownXyGravity;
        this.showAtLocation = builder.showAtLocation;
        this.xoff = builder.xoff;
        this.yoff = builder.yoff;
        this.x = builder.x;
        this.y = builder.y;

        this.onSureCancelClickListener = builder.onSureCancelClickListener;
        this.onItemClickListener = builder.onItemClickListener;

        switch (dialogType) {
            case DIALOG_ALTER_TYPE:
                dialog = new AlterDialog();
                break;
            case DIALOG_ALTER_SELECT_TYPE:
                dialog = new AlterSelectDialog();
                break;
            case DIALOG_SELECT_TYPE:
                dialog = new SelectDialog();
                break;
            case POPUPWINDOW_SELECT_TYPE:
                dialog = new SelectPopupWindow();
                break;
        }

    }

    public void show() {
        dialog.show(this);
    }

    public void cancel() {
        dialog.cancel();
    }

    public static final class Builder {

        private Context context;

        private String title;
        private String[] itemArray;
        private int titleColor;
        private int titleSize;

        private String message;
        private int messageColor;
        private int messageSize;

        private String sureButton;
        private int sureButtonSize;
        private int sureButtonColor;

        private String cancelButton;
        private int cancelButtonSize;
        private int cancelButtonColor;

        private boolean cancelable = true;
        private boolean canceledOnTouchOutside = true;
        private int animation;
        private View anchorView;
        private View parent;
        private boolean showAsDropDown;
        private boolean showAsDropDownXy;
        private boolean showAsDropDownXyGravity;
        private boolean showAtLocation;
        private int xoff;
        private int yoff;
        private int x;
        private int y;
        private int dialogType;
        private int gravity = Gravity.CENTER;


        private OnSureCancelClickListener onSureCancelClickListener;
        private OnItemClickListener onItemClickListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitle(@StringRes int titleId) {
            if (context == null) return this;
            this.title = context.getResources().getString(titleId);
            return this;
        }

        public Builder setTitleSize(int titleSize) {
            this.titleSize = titleSize;
            return this;
        }

        public Builder setTitleSizeResId(@DimenRes int titleSizeId) {
            if (context == null) return this;
            this.titleSize = context.getResources().getDimensionPixelSize(titleSizeId);
            return this;
        }

        public Builder setTitleColor(int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public Builder setTitleColorResId(@ColorRes int titleColorId) {
            if (context == null) return this;
            this.titleColor = context.getResources().getColor(titleColorId);
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(@StringRes int messageId) {
            if (context == null) return this;
            this.message = context.getResources().getString(messageId);
            return this;
        }

        public Builder setMessageSize(int messageSize) {
            this.messageSize = messageSize;
            return this;
        }

        public Builder setMessageSizeResId(@DimenRes int messageSizeId) {
            if (context == null) return this;
            this.messageSize = context.getResources().getDimensionPixelSize(messageSizeId);
            return this;
        }

        public Builder setMessageColor(int messageColor) {
            this.messageColor = messageColor;
            return this;
        }

        public Builder setMessageColorResId(@ColorRes int messageColorId) {
            if (context == null) return this;
            this.messageColor = context.getResources().getColor(messageColorId);
            return this;
        }

        public Builder setSureButton(String sureButton) {
            this.sureButton = sureButton;
            return this;
        }

        public Builder setSureButton(@StringRes int sureButtonId) {
            if (context == null) return this;
            this.sureButton = context.getResources().getString(sureButtonId);
            return this;
        }

        public Builder setSureButtonSize(int sureButtonSize) {
            this.sureButtonSize = sureButtonSize;
            return this;
        }

        public Builder setSureButtonSizeResId(@DimenRes int sureButtonSizeId) {
            if (context == null) return this;
            this.sureButtonSize = context.getResources().getDimensionPixelSize(sureButtonSizeId);
            return this;
        }

        public Builder setSureButtonColor(int sureButtonColor) {
            this.sureButtonColor = sureButtonColor;
            return this;
        }

        public Builder setSureButtonColorResId(@ColorRes int sureButtonColorId) {
            if (context == null) return this;
            this.sureButtonColor = context.getResources().getColor(sureButtonColorId);
            return this;
        }

        public Builder setCancelButton(String cancelButton) {
            this.cancelButton = cancelButton;
            return this;
        }

        public Builder setCancelButton(@StringRes int cancelButtonId) {
            if (context == null) return this;
            this.cancelButton = context.getResources().getString(cancelButtonId);
            return this;
        }

        public Builder setCancelButtonSize(int cancelButtonSize) {
            this.cancelButtonSize = cancelButtonSize;
            return this;
        }

        public Builder setCancelButtonSizeResId(@DimenRes int cancelButtonSizeId) {
            if (context == null) return this;
            this.cancelButtonSize = context.getResources().getDimensionPixelSize(cancelButtonSizeId);
            return this;
        }

        public Builder setCancelButtonColor(int cancelButtonColor) {
            this.cancelButtonColor = cancelButtonColor;
            return this;
        }

        public Builder setCancelButtonColorResId(@ColorRes int cancelButtonColorId) {
            if (context == null) return this;
            this.cancelButtonColor = context.getResources().getColor(cancelButtonColorId);
            return this;
        }

        public Builder setItemArray(String[] itemArray) {
            this.itemArray = itemArray;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setCanceledOnTouchOutside(boolean cancelable) {
            this.canceledOnTouchOutside = cancelable;
            return this;
        }

        public Builder setAnimation(int animation) {
            this.animation = animation;
            return this;
        }

        public Builder setAsDropDown(View anchorView) {
            this.anchorView = anchorView;
            this.showAsDropDown = true;
            return this;
        }

        public Builder setAsDropDown(View anchorView, int xoff, int yoff) {
            this.anchorView = anchorView;
            this.xoff = xoff;
            this.yoff = yoff;
            this.showAsDropDownXy = true;
            return this;
        }

        public Builder setAsDropDown(View anchorView, int xoff, int yoff, int gravity) {
            this.anchorView = anchorView;
            this.xoff = xoff;
            this.yoff = yoff;
            this.gravity = gravity;
            this.showAsDropDownXyGravity = true;
            return this;
        }

        public Builder showAtLocation(View parent, int x, int y, int gravity) {
            this.parent = parent;
            this.x = x;
            this.y = y;
            this.gravity = gravity;
            this.showAtLocation = true;
            return this;
        }

        public Builder setDialogType(int dialogType) {
            this.dialogType = dialogType;
            return this;
        }

        public Builder setGravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public Builder setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
            return this;
        }

        public Builder setOnSureCancelClickListener(OnSureCancelClickListener onSureCancelClickListener) {
            this.onSureCancelClickListener = onSureCancelClickListener;
            return this;
        }

        public UniversalDialog create() {
            return new UniversalDialog(this);
        }

    }

}
