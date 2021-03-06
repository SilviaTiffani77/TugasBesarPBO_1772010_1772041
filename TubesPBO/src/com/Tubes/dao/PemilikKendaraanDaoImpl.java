package com.Tubes.dao;

import com.Tubes.entity.PemilikKendaran;
import com.Tubes.entity.Status;
import com.Tubes.util.DBHelper;
import com.Tubes.util.DaoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PemilikKendaraanDaoImpl implements DaoService<PemilikKendaran> {
    @Override
    public List<PemilikKendaran> showAll() {
        List<PemilikKendaran> pemilikKendarans = new ArrayList<>();
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "SELECT * FROM pemilik_kendaraan";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Status status = new Status();
                status.setIdstatus(rs.getInt("id_Status"));
                status.setStatus(rs.getString("status"));

                PemilikKendaran pemilikKendaran = new PemilikKendaran();
                pemilikKendaran.setNik(rs.getInt("nik_pemilik_kendaraan"));
                pemilikKendaran.setNama(rs.getString("nama"));
                pemilikKendaran.setNoKendaraan1(rs.getString("no_kendaraan_1"));
                pemilikKendaran.setNoKendaraan2(rs.getString("no_kendaraan_2"));
                pemilikKendaran.setJenisKendaraan1(rs.getString("jenis_kendaraan_1"));
                pemilikKendaran.setJenisKendaraan2(rs.getString("jenis_kendaraan_2"));
                pemilikKendaran.setIdStatus(rs.getInt("id_Status"));
                pemilikKendaran.setStatus(status);

                pemilikKendarans.add(pemilikKendaran);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pemilikKendarans;
    }

    @Override
    public int addData(PemilikKendaran object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "INSERT INTO pemilik_kendaraan(nik_pemilik_kendaraan, nama, no_kendaraan_1, jenis_kendaraan_1, no_kendaraan_2, jenis_kendaraan_2, id_Status) VALUE (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, object.getNik());
            ps.setString(2, object.getNama());
            ps.setString(3, object.getNoKendaraan1());
            ps.setString(4, object.getJenisKendaraan1());
            ps.setString(5, object.getNoKendaraan2());
            ps.setString(6, object.getJenisKendaraan2());
            ps.setString(7, object.getIdStatus());
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
    public int updateData(PemilikKendaran object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "UPDATE pemilik_kendaraan SET no_kendaraan_1 = ?, jenis_kendaraan_1, no_kendaraan_2, jenis_kendaraan_2 = ? WHERE nik_pemilik_kendaraan = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, object.getNoKendaraan1());
            ps.setString(2, object.getJenisKendaraan1());
            ps.setString(3, object.getNoKendaraan2());
            ps.setString(4, object.getJenisKendaraan2());
            ps.setInt(5, object.getNik());
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
    public int deleteData(PemilikKendaran object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "DELETE FROM pemilik_kendaraan WHERE nik_pemilik_kendaraan = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, object.getNik());
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
