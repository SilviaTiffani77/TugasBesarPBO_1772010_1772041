package com.Tubes.dao;

import java.sql.SQLException;
import java.util.List;

public interface DaoService<T> {
  int addData(T object) throws SQLException;

  int updateData(T object) throws SQLException;

  int deleteData(T object) throws SQLException;

  List<T> getAllData() throws SQLException;
}
