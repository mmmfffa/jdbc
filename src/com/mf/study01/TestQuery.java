package com.mf.study01;

import com.mf.utils.UtilsJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author mf
 * @create 2021-05-18-9:38
 */
public class TestQuery {
    public static void main(String[] args) throws SQLException {
        Connection connection =null;
        Statement statement =null;
        ResultSet resultSet=null;
        try {
            connection = UtilsJDBC.getConnection();
            statement = connection.createStatement();
            String sql="SELECT * FROM `users` where `id`=3;";
            resultSet = statement.executeQuery(sql);//返回结果集
            while (resultSet.next()){
                System.out.println("id=" + resultSet.getObject("id"));
                System.out.println("name=" + resultSet.getObject("name"));
                System.out.println("password=" + resultSet.getObject("password"));
                System.out.println("email=" + resultSet.getObject("email"));
                System.out.println("birthday=" + resultSet.getObject("birthday"));
                System.out.println("=========================================================");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UtilsJDBC.releaseConnection(connection, statement, resultSet);
        }
    }
}
