package com.nhom5_btl.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AppCompatActivity;

public class CustomAlertDialog {
    public static AlertDialog buildAlertDialogExit(Context context) {
        int themeResId = android.R.style.Theme_DeviceDefault_Light_Dialog_Alert;
        AlertDialog.Builder b = new AlertDialog.Builder(context, themeResId);
        b.setTitle("Xác nhận");
        b.setMessage("Bạn có đồng ý thoát chương trình không?");
        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                ((AppCompatActivity) context).finishAffinity();
            }
        });
        b.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        return b.create();
    }

    public static AlertDialog buildAlertDialogExists(Context context) {
        int themeResId = android.R.style.Theme_DeviceDefault_Light_Dialog_Alert;
        AlertDialog.Builder b = new AlertDialog.Builder(context, themeResId);
        b.setTitle("Thêm báo cáo thất bại");
        b.setMessage("Báo cáo đã tồn tại");
        b.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        return b.create();
    }
}
