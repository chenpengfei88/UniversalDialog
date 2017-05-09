package com.free.universaldialog.widget;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.free.universaldialog.R;
import com.free.universaldialog.UniversalDialog;
import com.free.universaldialog.base.AbsDialog;

/**
 * Created by chenpengfei on 2017/3/23.
 */
public class AlterDialog extends AbsDialog {

    @Override
    public void show(final UniversalDialog universalDialog) {
        View contentView = LayoutInflater.from(universalDialog.context).inflate(R.layout.dialog_alter, null);

        TextView titleTextView = (TextView) contentView.findViewById(R.id.textview_title);
        TextView messageTextView = (TextView) contentView.findViewById(R.id.textview_message);
        TextView sureTextView = (TextView) contentView.findViewById(R.id.textview_sure);
        TextView cancelTextView = (TextView) contentView.findViewById(R.id.textview_cancel);

        titleTextView.setText(universalDialog.title);
        titleTextView.setTextSize(universalDialog.titleSize);
        titleTextView.setTextColor(universalDialog.titleColor);
        titleTextView.setVisibility(TextUtils.isEmpty(universalDialog.title) ? View.GONE : View.VISIBLE);

        messageTextView.setText(universalDialog.message);
        messageTextView.setTextSize(universalDialog.messageSize);
        messageTextView.setTextColor(universalDialog.messageColor);
        messageTextView.setVisibility(TextUtils.isEmpty(universalDialog.message) ? View.GONE : View.VISIBLE);

        sureTextView.setText(universalDialog.sureButton);
        sureTextView.setTextSize(universalDialog.sureButtonSize);
        sureTextView.setTextColor(universalDialog.sureButtonColor);
        sureTextView.setVisibility(TextUtils.isEmpty(universalDialog.sureButton) ? View.GONE : View.VISIBLE);
        sureTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.cancel();
                if (universalDialog.onSureCancelClickListener != null) universalDialog.onSureCancelClickListener.onSure(v);
                if (universalDialog.onSureClickListener != null) universalDialog.onSureClickListener.onSure(v);
            }
        });

        cancelTextView.setText(universalDialog.cancelButton);
        cancelTextView.setTextSize(universalDialog.cancelButtonSize);
        cancelTextView.setTextColor(universalDialog.cancelButtonColor);
        cancelTextView.setVisibility(TextUtils.isEmpty(universalDialog.cancelButton) ? View.GONE : View.VISIBLE);
        cancelTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.cancel();
                if (universalDialog.onSureCancelClickListener != null) universalDialog.onSureCancelClickListener.onCancel(v);
            }
        });

        initDialog(universalDialog, contentView);
    }

}
