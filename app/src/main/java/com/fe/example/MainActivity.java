package com.fe.example;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import com.free.universaldialog.UniversalDialog;
import com.free.universaldialog.listener.OnSureClickListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.textview_alert).setOnClickListener(this);
        findViewById(R.id.textview_select_alert).setOnClickListener(this);
        findViewById(R.id.textview_bottom).setOnClickListener(this);
        findViewById(R.id.textview_top).setOnClickListener(this);
        findViewById(R.id.textview_tip).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        UniversalDialog.Builder builder = new UniversalDialog.Builder(this);
        switch (v.getId()) {
            case R.id.textview_alert:
                 builder.setTitle("提示")
                           .setMessage("确认关掉我吗？")
                            .setSureButton("确定")
                            .setCancelButton("不关")
                            .setOnSureClickListener(new OnSureClickListener() {
                                @Override
                                public void onSure() {
                                    Toast.makeText(MainActivity.this, "Sure", Toast.LENGTH_SHORT).show();
                                }
                            })
                             .create().show();
                break;
            case R.id.textview_select_alert:
                builder.setDialogType(UniversalDialog.DIALOG_ALTER_SELECT_TYPE)
                           .setMessageColor(Color.parseColor("#000000"))
                           .setItemArray(new String[] {"拍照", "相册", "视频"})
                           .create().show();
                break;
            case R.id.textview_bottom:
                builder.setDialogType(UniversalDialog.DIALOG_SELECT_TYPE)
                        .setGravity(Gravity.BOTTOM)
                        .setAnimation(R.style.dialog_animation_bottom)
                        .setMessageColor(Color.parseColor("#000000"))
                        .setItemArray(new String[] {"拍照", "相册", "视频"})
                        .create().show();
                break;
            case R.id.textview_top:
                builder.setDialogType(UniversalDialog.POPUPWINDOW_SELECT_TYPE)
                        .setAsDropDown(findViewById(R.id.textview_bar))
                        .setMessageColor(Color.parseColor("#000000"))
                        .setItemArray(new String[] {"拍照", "相册", "视频"})
                        .setCancelable(true)
                        .create().show();
                break;
            case R.id.textview_tip:
                builder.customDialog(new TipDialog(this)).show();
                break;
            default:
                break;
        }
    }
}
