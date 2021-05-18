package com.mf.study01;

import com.mf.utils.UtilsJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author mf
 * @create 2021-05-18-9:35
 */
public class TestUpdate {
    public static void main(String[] args) throws SQLException {
        Connection connection =null;
        Statement statement =null;
        ResultSet resultSet=null;
        try {
            connection = UtilsJDBC.getConnection();
            statement = connection.createStatement();
            String sql="UPDATE `users` SET `email`='966' WHERE `name`='上官婉儿';";
            int i = statement.executeUpdate(sql);
            if(i>0) System.out.println("更新成功");
            else System.out.println("更新失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UtilsJDBC.releaseConnection(connection, statement, resultSet);
        }
    }
}
