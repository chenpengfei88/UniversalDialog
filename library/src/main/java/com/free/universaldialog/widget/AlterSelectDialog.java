package com.free.universaldialog.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.free.universaldialog.R;
import com.free.universaldialog.UniversalDialog;
import com.free.universaldialog.base.AbsDialog;

/**
 * Created by chenpengfei on 2017/3/23.
 */
public class AlterSelectDialog extends AbsDialog {

    @Override
    public void show(final UniversalDialog universalDialog) {
        View contentView = LayoutInflater.from(universalDialog.context).inflate(R.layout.dialog_alter_select, null);
        LinearLayout containerLl = (LinearLayout) contentView.findViewById(R.id.ll_container);
        final String[] itemArray = universalDialog.itemArray;
        if (itemArray != null && itemArray.length > 0) {
            for (int i = 0, length = itemArray.length; i < length; i++) {
                TextView itemTextView = getItemTextView(universalDialog, itemArray[i]);
                containerLl.addView(itemTextView);
                if (i != length - 1)
                    containerLl.addView(getDivideLineView(universalDialog.context));

                final int position = i;
                itemTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.cancel();
                        if (universalDialog.onItemClickListener != null) {
                            universalDialog.onItemClickListener.onItemClick(itemArray[position], position);
                        }
                    }
                });
            }
        }

        initDialog(universalDialog, contentView);
    }

    @Override
    public void cancel() {

    }

    private TextView getItemTextView(UniversalDialog universalDialog, String item) {
        TextView itemTextView = new TextView(universalDialog.context);
        itemTextView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        itemTextView.setText(item);
        itemTextView.setTextSize(universalDialog.messageSize);
        itemTextView.setTextColor(universalDialog.messageColor);
        itemTextView.setPadding(40, 40, 40, 40);
        return itemTextView;
    }

    private View getDivideLineView(Context context) {
        View divideLine = new View(context);
        divideLine.setBackgroundColor(Color.parseColor("#C7C7C7"));
        RelativeLayout.LayoutParams lineLp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        divideLine.setLayoutParams(lineLp);
        return divideLine;
    }
}
