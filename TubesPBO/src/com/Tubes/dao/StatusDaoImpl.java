package com.Tubes.dao;

import com.Tubes.entity.Kendaraan;
import com.Tubes.entity.ParkirMasuk;
import com.Tubes.entity.Status;
import com.Tubes.util.DBHelper;
import com.Tubes.util.DaoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDaoImpl implements DaoService<Status> {

    @Override
    public List<Status> showAll() {
        List<Status> statuses = new ArrayList<>();
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "SELECT * FROM status" ;
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Status status = new Status();
                status.setIdstatus(rs.getInt("id_Status"));
                status.setStatus(rs.getString("status"));
                statuses.add(status);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    @Override
    public int addData(Status object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "INSERT INTO status(id_Status, status) VALUES(?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, object.getIdstatus());
            ps.setString(2, object.getStatus());
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
    public int updateData(Status object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "UPDATE status SET status=? where id_Status= ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, object.getIdstatus());
            ps.setString(2, object.getStatus());
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
    public int deleteData(Status object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "DELETE FROM status WHERE id_Status= ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, object.getIdstatus());
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
