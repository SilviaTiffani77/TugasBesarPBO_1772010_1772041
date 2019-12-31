package com.Tubes.dao;

import com.Tubes.entity.ParkirKeluar;
import com.Tubes.entity.ParkirMasuk;
import com.Tubes.util.DBHelper;
import com.Tubes.util.DaoService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkirMasukDaoImpl implements DaoService<ParkirMasuk> {
    @Override
    public List<ParkirMasuk> showAll() {
        List<ParkirMasuk> parkirMasuks = new ArrayList<>();
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "SELECT * FROM parkir_masuk pm join petugas p on pm.kode_petugas = p.kode_petugas";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ParkirKeluar parkirKeluar = new ParkirKeluar();
                parkirKeluar.setNoParkir(rs.getString("no_parkir"));
                parkirKeluar.setJamKeluar(rs.getTime("jam_keluar"));
                parkirKeluar.setTanggal_keluar(rs.getDate("tanggal_keluar"));
                parkirKeluar.setKodePetugas(rs.getInt("kode_petugas"));

                ParkirMasuk parkirMasuk = new ParkirMasuk();
                parkirMasuk.setNoParkir(rs.getString("no_parkir"));
                parkirMasuk.setTglMasuk(rs.getDate("tanggal_masuk"));
                parkirMasuk.setJam_masuk(rs.getTime("jam_masuk"));
                parkirMasuk.setKodePetugas(rs.getInt("kode_petugas"));
                parkirMasuk.setParkirKeluar(parkirKeluar);

                parkirMasuks.add(parkirMasuk);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parkirMasuks;
    }

    @Override
    public int addData(ParkirMasuk object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "INSERT INTO parkir_masuk(no_parkir, tanggal_masuk, jam_masuk, kode_petugas) VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, object.getNoParkir());
            ps.setDate(2, object.getTglMasuk());
            ps.setTime(3, object.getJam_masuk());
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
    public int updateData(ParkirMasuk object) {
        return 0;
    }


    @Override
    public int deleteData(ParkirMasuk object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "DELETE FROM parkir_masuk WHERE no_parkir = ?";
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
