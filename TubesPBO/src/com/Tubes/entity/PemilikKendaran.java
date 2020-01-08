package com.Tubes.entity;

public class PemilikKendaran {
    private int nik;
    private String nama;
    private String noKendaraan1;
    private String jenisKendaraan1;
    private String noKendaraan2;
    private String jenisKendaraan2;

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    private int idStatus;
    private Status status;


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public int getNik() {
        return nik;
    }

    public void setNik(int nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoKendaraan1() {
        return noKendaraan1;
    }

    public void setNoKendaraan1(String noKendaraan1) {
        this.noKendaraan1 = noKendaraan1;
    }

    public String getJenisKendaraan1() {
        return jenisKendaraan1;
    }

    public void setJenisKendaraan1(String jenisKendaraan1) {
        this.jenisKendaraan1 = jenisKendaraan1;
    }

    public String getNoKendaraan2() {
        return noKendaraan2;
    }

    public void setNoKendaraan2(String noKendaraan2) {
        this.noKendaraan2 = noKendaraan2;
    }

    public String getJenisKendaraan2() {
        return jenisKendaraan2;
    }

    public void setJenisKendaraan2(String jenisKendaraan2) {
        this.jenisKendaraan2 = jenisKendaraan2;
    }


}
