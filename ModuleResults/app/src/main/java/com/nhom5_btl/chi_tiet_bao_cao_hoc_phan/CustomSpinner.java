package com.nhom5_btl.chi_tiet_bao_cao_hoc_phan;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nhom5_btl.R;
import com.nhom5_btl.models.HocPhan;

import java.util.ArrayList;

public class CustomSpinner extends ArrayAdapter<HocPhan> {
    Activity context;
    int layoutID;
    ArrayList<HocPhan> list;

    public CustomSpinner(@NonNull Activity context, int layoutID, @NonNull ArrayList<HocPhan> objects) {
        super(context, layoutID, objects);
        this.context = context;
        this.layoutID = layoutID;
        this.list = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(layoutID, null);
        }
        if (list.size() > 0) {

            TextView txtMaHP = convertView.findViewById(R.id.txtMaHP);
            TextView txtTenHP = convertView.findViewById(R.id.txtTenHP);

            txtMaHP.setText(list.get(position).getMaHocPhan());
            txtTenHP.setText(list.get(position).getTenHocPhan());
        }
        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(layoutID, null);
        }
        if (list.size() > 0) {

            LinearLayout customSpinnerBCHP = convertView.findViewById(R.id.customSpinnerBCHP);
            customSpinnerBCHP.setPadding(0, 0, 0, 0);

            TextView txtMaHP = convertView.findViewById(R.id.txtMaHP);
            TextView txtTenHP = convertView.findViewById(R.id.txtTenHP);

            txtMaHP.setText(list.get(position).getMaHocPhan());
            txtTenHP.setText(list.get(position).getTenHocPhan());
        }
        return convertView;
    }
}
