package com.mf.study01;

import com.mf.utils.UtilsJDBC;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author mf
 * @create 2021-05-18-9:06
 */
public class TestInsert {
    public static void main(String[] args) throws SQLException {
        Connection connection =null;
        Statement statement =null;
        ResultSet resultSet=null;
        try {
           connection = UtilsJDBC.getConnection();
           statement = connection.createStatement();
           String sql="INSERT INTO `users`(`id`,`name`,`password`,`email`,`birthday`) VALUES\n" +
                    "('3','上官婉儿','3344','qq.com','2000-10-1');";
           int i = statement.executeUpdate(sql);
           if(i>0) System.out.println("插入成功");
           else System.out.println("插入失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UtilsJDBC.releaseConnection(connection, statement, resultSet);
        }
    }
}
