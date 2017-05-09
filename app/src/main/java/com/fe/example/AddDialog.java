package com.fe.example;

import android.content.Context;
import android.view.View;
import com.free.universaldialog.base.AbsCustomDialog;

/**
 * Created by chenpengfei on 2017/5/5.
 */
public class AddDialog extends AbsCustomDialog {

    private View mSureView;

    public AddDialog(Context context) {
        inflaterView(context, R.layout.dialog_add);
    }

    @Override
    public View getSureView() {
        return mSureView;
    }

    @Override
    protected void initView(View contentView) {
        mSureView = contentView.findViewById(R.id.textview_sure);
    }
}
