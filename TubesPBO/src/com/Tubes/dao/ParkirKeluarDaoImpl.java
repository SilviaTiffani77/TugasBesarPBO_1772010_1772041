package com.Tubes.dao;

import com.Tubes.entity.ParkirKeluar;
import com.Tubes.entity.ParkirMasuk;
import com.Tubes.util.DBHelper;
import com.Tubes.util.DaoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkirKeluarDaoImpl implements DaoService<ParkirKeluar> {
    @Override
    public List<ParkirKeluar> showAll() {
        List<ParkirKeluar> parkirKeluars = new ArrayList<>();
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "SELECT * FROM parkir_keluar pk JOIN parkir_masuk ps JOIN petugas p ON pk.no_parkir = ps.no_parkirr" +
                    "ON pk.kode_petugas = p.kode_petugas" ;
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ParkirMasuk parkirMasuk = new ParkirMasuk();
                parkirMasuk.setNoParkir(rs.getString("no_parkir"));
                parkirMasuk.setTglMasuk(rs.getDate("tanggal_masuk"));
                parkirMasuk.setJam_masuk(rs.getTime("jam_masuk"));
                parkirMasuk.setKodePetugas(rs.getInt("kode_petugas"));

                ParkirKeluar parkirKeluar = new ParkirKeluar();
                parkirKeluar.setNoParkir(rs.getString("no_parkir"));
                parkirKeluar.setJamKeluar(rs.getTime("jam_keluar"));
                parkirKeluar.setTanggal_keluar(rs.getDate("tanggal_keluar"));
                parkirKeluar.setKodePetugas(rs.getInt("kode_petugas"));
                parkirKeluar.setParkirMasuk(parkirMasuk);

                parkirKeluars.add(parkirKeluar);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parkirKeluars;
    }

    @Override
    public int addData(ParkirKeluar object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "INSERT INTO parkir_keluar(no_parkir, jam_keluar, tanggal_keluar, kode_petugas) VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, object.getNoParkir());
            ps.setTime(2, object.getJamKeluar());
            ps.setDate(3, object.getTanggal_keluar());
            ps.setInt(4, object.getKodePetugas());
            if (ps.executeUpdate() != 0){
                connection.commit();
                result = 1;
            } else {
                connection.rollback();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int updateData(ParkirKeluar object) {
        return 0;
    }

    @Override
    public int deleteData(ParkirKeluar object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "DELETE FROM parkir_keluar WHERE no_parkir = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, object.getNoParkir() );
            if (ps.executeUpdate() != 0){
                connection.commit();
                result = 1;
            } else {
                connection.rollback();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
