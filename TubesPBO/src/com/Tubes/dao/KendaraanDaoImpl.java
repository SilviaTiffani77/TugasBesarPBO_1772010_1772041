package com.Tubes.dao;

import com.Tubes.entity.Kendaraan;
import com.Tubes.util.DBHelper;
import com.Tubes.util.DaoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KendaraanDaoImpl implements DaoService<Kendaraan> {
    @Override
    public List<Kendaraan> showAll() {
        List<Kendaraan> kendaraans = new ArrayList<>();
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "SELECT * FROM kendaraan k JOIN parkir_masuk ps JOIN pemilik_kendaraan pk ON k.no_parkir = ps.no_parkir" +
                    "ON k.nik_pemilik_kendaraan = pk.nik_pemilik_kendaraan" ;
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Kendaraan kendaraan = new Kendaraan();
                kendaraan.setNoKendaraan(rs.getString("no_kendaraan"));
                kendaraan.setJenisKendaraan(rs.getString("jenis_kendaraan"));
                kendaraan.setTarif(rs.getInt("tarif"));
                kendaraan.setNoParkir(rs.getString("no_parkir"));
                kendaraan.setNIK(rs.getInt("nik_pemilik_kendaraan"));
                kendaraans.add(kendaraan);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kendaraans;
    }

    @Override
    public int addData(Kendaraan object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "INSERT INTO kendaraan(no_kendaraan, jenis_kendaraan, tarif, no_parkir, nik_pemilik_kendaraan) VALUES(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, object.getNoKendaraan());
            ps.setString(2, object.getJenisKendaraan());
            ps.setInt(3, object.getTarif());
            ps.setString(4, object.getNoParkir());
            ps.setInt(5, object.getNIK());
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
    public int updateData(Kendaraan object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "UPDATE kendaraan SET no_kendaraan = ?, jenis_kendaraan = ?, tarif = ? where nik_pemilik_kendaraan = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, object.getNoKendaraan());
            ps.setString(2, object.getJenisKendaraan());
            ps.setInt(3,object.getTarif());
            ps.setInt(4, object.getNIK());
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
    public int deleteData(Kendaraan object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "DELETE FROM kendaraan WHERE no_kendaraan = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, object.getNoKendaraan());
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
