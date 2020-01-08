package com.Tubes.entity;

import java.sql.Time;
import java.util.Date;

public class ParkirMasuk {
    private String noParkir;
    private Date tglMasuk;
    private Time jam_masuk;
    private int kodePetugas;
    private ParkirKeluar parkirKeluar;

    public Time getJam_masuk() {
        return jam_masuk;
    }

    public ParkirKeluar getParkirKeluar() {
        return parkirKeluar;
    }

    public void setParkirKeluar(ParkirKeluar parkirKeluar) {
        this.parkirKeluar = parkirKeluar;
    }


    public String getNoParkir() {
        return noParkir;
    }

    public void setNoParkir(String noParkir) {
        this.noParkir = noParkir;
    }

    public java.sql.Date getTglMasuk() {
        return (java.sql.Date) tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public Time getJam_masuk(Time jam_masuk) {
        return this.jam_masuk;
    }

    public void setJam_masuk(Time jam_masuk) {
        this.jam_masuk = jam_masuk;
    }

    public int getKodePetugas() {
        return kodePetugas;
    }

    public void setKodePetugas(int kodePetugas) {
        this.kodePetugas = kodePetugas;
    }

}
