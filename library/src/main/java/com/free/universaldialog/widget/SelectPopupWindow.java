package com.free.universaldialog.widget;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.free.universaldialog.R;
import com.free.universaldialog.UniversalDialog;
import com.free.universaldialog.base.AbsPopupWindow;

/**
 * Created by chenpengfei on 2017/3/27.
 */
public class SelectPopupWindow extends AbsPopupWindow {

    private LinearLayout rootLl;
    private LinearLayout containerLl;

    @Override
    public void show(final UniversalDialog universalDialog) {
        View contentView = LayoutInflater.from(universalDialog.context).inflate(R.layout.popupwindow_select, null);

        rootLl = (LinearLayout) contentView.findViewById(R.id.ll_root);
        rootLl.getBackground().setAlpha(universalDialog.popupWindowAlpha);
        containerLl = (LinearLayout) contentView.findViewById(R.id.ll_container);

        final String[] itemArray = universalDialog.itemArray;
        if (itemArray != null && itemArray.length > 0) {
            for (int i = 0, length = itemArray.length; i < length; i++) {
                TextView itemTextView = getItemTextView(universalDialog, itemArray[i]);
                containerLl.addView(itemTextView);
                if (i != length - 1)
                    containerLl.addView(getDivideLineView(universalDialog));

                final int position = i;
                itemTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopupWindow.dismiss();
                        if (universalDialog.onItemClickListener != null) {
                            universalDialog.onItemClickListener.onItemClick(itemArray[position], position);
                        }
                    }
                });
            }
        }

        if (universalDialog.cancelable) {
            rootLl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPopupWindow.dismiss();
                }
            });
        }

        initPopupWindow(universalDialog, contentView);
    }

    @Override
    protected void showLocation(UniversalDialog universalDialog) {
        if (universalDialog.anchorView == null) return;
        super.showLocation(universalDialog);

        LinearLayout.LayoutParams containerLlLp = (LinearLayout.LayoutParams) containerLl.getLayoutParams();
        if (universalDialog.showAsDropDownXy) {
            mPopupWindow.showAsDropDown(universalDialog.anchorView, universalDialog.xoff, universalDialog.yoff);
            containerLlLp.leftMargin = universalDialog.xoff;
            containerLlLp.topMargin = universalDialog.yoff;
        }
        if (universalDialog.showAsDropDownXyGravity) {
            rootLl.setGravity(universalDialog.gravity);
            containerLlLp.leftMargin = universalDialog.xoff;
            containerLlLp.topMargin = universalDialog.yoff;
        }
    }

    private TextView getItemTextView(UniversalDialog universalDialog, String item) {
        TextView itemTextView = new TextView(universalDialog.context);
        itemTextView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        itemTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        itemTextView.setText(item);
        itemTextView.setTextSize(universalDialog.messageSize);
        itemTextView.setTextColor(universalDialog.messageColor);
        itemTextView.setPadding(0, 40, 0, 40);
        return itemTextView;
    }

    private View getDivideLineView(UniversalDialog universalDialog) {
        View divideLine = new View(universalDialog.context);
        divideLine.setBackgroundColor(universalDialog.divideColor);
        RelativeLayout.LayoutParams lineLp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, universalDialog.divideHeight);
        divideLine.setLayoutParams(lineLp);
        return divideLine;
    }

}
