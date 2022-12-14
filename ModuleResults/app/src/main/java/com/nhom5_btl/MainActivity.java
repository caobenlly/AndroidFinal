package com.nhom5_btl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nhom5_btl.dashboard.Dashboard;
import com.nhom5_btl.database.MyDatabaseHelper;
import com.nhom5_btl.models.BaoCaoGiangDay;
import com.nhom5_btl.models.BaoCaoHocPhan;
import com.nhom5_btl.models.GiangVien;
import com.nhom5_btl.models.HocPhan;
import com.nhom5_btl.models.LopHoc;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences = null;
    Button btnLogin;
    CheckBox ckbSaveAccount;
    EditText editUsername, editPassword;
    MyDatabaseHelper databaseHelper = null;

    String usernamePref, passwordPref, saveAccountPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("auth", MODE_PRIVATE);

        databaseHelper = MyDatabaseHelper.getInstance(getApplicationContext());

        getWidget();

        initHocPhan();
        initGiangVien();
        initLopHoc();
        initDataBaoCaoDemo();

        usernamePref = sharedPreferences.getString("username", "");
        passwordPref = sharedPreferences.getString("password", "");
        saveAccountPref = sharedPreferences.getString("saveAccount", "");

        editUsername.setText(usernamePref);
        editPassword.setText(passwordPref);
        ckbSaveAccount.setChecked(Boolean.parseBoolean(saveAccountPref));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GiangVien giangVien = login(editUsername.getText().toString(),
                        editPassword.getText().toString());

                if (giangVien != null) {
                    Intent intent = new Intent(MainActivity.this, Dashboard.class);
                    intent.putExtra("giangVien", giangVien);
                    startActivity(intent);

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("saveAccount", String.valueOf(ckbSaveAccount.isChecked()));
                    if (ckbSaveAccount.isChecked()) {
                        editor.putString("username", giangVien.getUsername());
                        editor.putString("password", giangVien.getPassword());
                    } else {
                        editor.putString("username", "");
                        editor.putString("password", "");
                        editUsername.setText("");
                        editPassword.setText("");
                    }
                    editor.apply();

                } else {
                    Toast.makeText(getApplicationContext(), "????ng nh???p th???t b???i", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initDataBaoCaoDemo() {
        if (databaseHelper.getTotalRecord(MyDatabaseHelper.TABLE_BAO_CAO_HOC_PHAN) == 0) {
            BaoCaoHocPhan baoCaoHocPhan1 = new BaoCaoHocPhan(1, "IT6029",
                    5, 4, "T??? ch???n");
            BaoCaoHocPhan baoCaoHocPhan2 = new BaoCaoHocPhan(1, "IT6030",
                    3, 8, "T??? ch???n");
            BaoCaoHocPhan baoCaoHocPhanNew1 = databaseHelper.insertBaoCaoHocPhan(baoCaoHocPhan1);
            BaoCaoHocPhan baoCaoHocPhanNew2 = databaseHelper.insertBaoCaoHocPhan(baoCaoHocPhan2);

            BaoCaoGiangDay baoCaoGiangDay1 = new BaoCaoGiangDay(1, 1,
                    baoCaoHocPhanNew1.getMaBaoCaoHocPhan(), 1, 8,
                    60, 5, "L?? thuy???t");
            BaoCaoGiangDay baoCaoGiangDay2 = new BaoCaoGiangDay(2, 3,
                    baoCaoHocPhanNew2.getMaBaoCaoHocPhan(), 3, 5,
                    65, 4, "L?? thuy???t");
            databaseHelper.insertBaoCaoGiangDay(baoCaoGiangDay1);
            databaseHelper.insertBaoCaoGiangDay(baoCaoGiangDay2);
        }
    }

    private void initHocPhan() {
        if (databaseHelper.getTotalRecord(MyDatabaseHelper.TABLE_HOC_PHAN) == 0) {
            HocPhan hocPhan1 = new HocPhan("IT6029",
                    "Ph??t tri???n ???ng d???ng tr??n thi???t b??? di ?????ng");
            HocPhan hocPhan2 = new HocPhan("IT6030", "Ph???n m???m m?? ngu???n m???");
            HocPhan hocPhan3 = new HocPhan("IT6019", "L???p tr??nh Java");
            databaseHelper.insertHocPhan(hocPhan1);
            databaseHelper.insertHocPhan(hocPhan2);
            databaseHelper.insertHocPhan(hocPhan3);
        }
    }

    private void initGiangVien() {
        if (databaseHelper.getTotalRecord(MyDatabaseHelper.TABLE_GIANG_VIEN) == 0) {
            GiangVien giangVien1 = new GiangVien(1, "V?? Th??? D????ng",
                    "admin", "admin");
            GiangVien giangVien2 = new GiangVien(2, "Nguy???n Th??i C?????ng",
                    "admin1", "admin");
            GiangVien giangVien3 = new GiangVien(3, "Nguy???n ?????c L??u",
                    "admin2", "admin");
            databaseHelper.insertGiangVien(giangVien1);
            databaseHelper.insertGiangVien(giangVien2);
            databaseHelper.insertGiangVien(giangVien3);
        }
    }

    private void initLopHoc() {
        if (databaseHelper.getTotalRecord(MyDatabaseHelper.TABLE_LOP_HOC) == 0) {
            LopHoc lopHoc1 = new LopHoc(1, "KTPM2", 80);
            LopHoc lopHoc2 = new LopHoc(2, "CNTT1", 75);
            LopHoc lopHoc3 = new LopHoc(3, "HTTT3", 78);
            databaseHelper.insertLopHoc(lopHoc1);
            databaseHelper.insertLopHoc(lopHoc2);
            databaseHelper.insertLopHoc(lopHoc3);
        }
    }

    public GiangVien login(String username, String password) {
        GiangVien giangVien = databaseHelper.getGiangVienByUsername(username);

        if (giangVien == null) {
            return null;
        }

        if (giangVien.getUsername().compareTo(username) == 0 &&
                giangVien.getPassword().compareTo(password) == 0) {
            return giangVien;
        }

        return null;
    }

    private void getWidget() {
        btnLogin = findViewById(R.id.btnLogin);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        ckbSaveAccount = findViewById(R.id.ckbSaveAccount);
    }
}