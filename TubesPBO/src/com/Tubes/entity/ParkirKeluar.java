package com.Tubes.entity;

import java.sql.Date;
import java.sql.Time;

public class ParkirKeluar {
    private Time jamKeluar;
    private Date tanggal_keluar;
    private String noParkir;
    private int kodePetugas;

    public ParkirMasuk getParkirMasuk() {
        return parkirMasuk;
    }

    public void setParkirMasuk(ParkirMasuk parkirMasuk) {
        this.parkirMasuk = parkirMasuk;
    }

    private ParkirMasuk parkirMasuk;

    public Time getJamKeluar() {
        return jamKeluar;
    }

    public void setJamKeluar(Time jamKeluar) {
        this.jamKeluar = jamKeluar;
    }

    public Date getTanggal_keluar() {
        return tanggal_keluar;
    }

    public void setTanggal_keluar(Date tanggal_keluar) {
        this.tanggal_keluar = tanggal_keluar;
    }

    public String getNoParkir() {
        return noParkir;
    }

    public void setNoParkir(String noParkir) {
        this.noParkir = noParkir;
    }

    public int getKodePetugas() {
        return kodePetugas;
    }

    public void setKodePetugas(int kodePetugas) {
        this.kodePetugas = kodePetugas;
    }

}
