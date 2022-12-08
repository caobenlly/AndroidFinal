package com.nhom5_btl.models;

public class BaoCaoGiangDay {
    private int maBaoCaoGiangDay;
    private int maGiangVien;
    private int maBaoCaoHocPhan;
    private int maLop;
    private float soGioTrenLop;
    private int siSo;
    private int soTietMotNgay;
    private String loaiTiet;

    public BaoCaoGiangDay() {
    }

    public BaoCaoGiangDay(int maBaoCaoGiangDay, int maGiangVien, int maBaoCaoHocPhan, int maLop,
                          float soGioTrenLop, int siSo, int soTietMotNgay, String loaiTiet) {
        this.maBaoCaoGiangDay = maBaoCaoGiangDay;
        this.maGiangVien = maGiangVien;
        this.maBaoCaoHocPhan = maBaoCaoHocPhan;
        this.maLop = maLop;
        this.soGioTrenLop = soGioTrenLop;
        this.siSo = siSo;
        this.soTietMotNgay = soTietMotNgay;
        this.loaiTiet = loaiTiet;
    }

    public int getMaBaoCaoGiangDay() {
        return maBaoCaoGiangDay;
    }

    public void setMaBaoCaoGiangDay(int maBaoCaoGiangDay) {
        this.maBaoCaoGiangDay = maBaoCaoGiangDay;
    }

    public int getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(int maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public int getMaBaoCaoHocPhan() {
        return maBaoCaoHocPhan;
    }

    public void setMaBaoCaoHocPhan(int maBaoCaoHocPhan) {
        this.maBaoCaoHocPhan = maBaoCaoHocPhan;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public float getSoGioTrenLop() {
        return soGioTrenLop;
    }

    public void setSoGioTrenLop(float soGioTrenLop) {
        this.soGioTrenLop = soGioTrenLop;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    public int getSoTietMotNgay() {
        return soTietMotNgay;
    }

    public void setSoTietMotNgay(int soTietMotNgay) {
        this.soTietMotNgay = soTietMotNgay;
    }

    public String getLoaiTiet() {
        return loaiTiet;
    }

    public void setLoaiTiet(String loaiTiet) {
        this.loaiTiet = loaiTiet;
    }

    @Override
    public String toString() {
        return "BaoCaoGiangDay{" +
                "maBaoCaoGiangDay=" + maBaoCaoGiangDay +
                ", maGiangVien=" + maGiangVien +
                ", maBaoCaoHocPhan=" + maBaoCaoHocPhan +
                ", maLop=" + maLop +
                ", soGioTrenLop=" + soGioTrenLop +
                ", siSo=" + siSo +
                ", soTietMotNgay=" + soTietMotNgay +
                ", loaiTiet='" + loaiTiet + '\'' +
                '}';
    }
}
