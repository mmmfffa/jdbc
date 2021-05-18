package com.mf.study01;

import com.mf.utils.UtilsJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author mf
 * @create 2021-05-18-9:33
 */
public class TestDelete {
    public static void main(String[] args) throws SQLException {
        Connection connection =null;
        Statement statement =null;
        ResultSet resultSet=null;
        try {
            connection = UtilsJDBC.getConnection();
            statement = connection.createStatement();
            String sql="DELETE FROM `users` WHERE `name`='张无忌';";
            int i = statement.executeUpdate(sql);
            if(i>0) System.out.println("删除成功");
            else System.out.println("删除失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UtilsJDBC.releaseConnection(connection, statement, resultSet);
        }
    }
}
