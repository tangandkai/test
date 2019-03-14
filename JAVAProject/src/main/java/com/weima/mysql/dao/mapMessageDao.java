package com.weima.mysql.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface mapMessageDao {

    public List query(Connection conn,String sql) throws SQLException, IOException;
    public String insert(Connection conn,String sql,List<?> content) throws SQLException;
}
