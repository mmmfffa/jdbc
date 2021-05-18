package com.mf.study01;

import com.mf.utils.UtilsJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author mf
 * @create 2021-05-18-10:49
 */
public class SqlPourInto {
    public static void main(String[] args) throws SQLException {
       // login("上官婉儿","123456");
        login(" 'or' 1=1"," 'or' 1=1");
    }
    public static void login(String name,String password) throws SQLException {
        Connection connection =null;
        Statement statement =null;
        ResultSet resultSet=null;
        try {
            connection = UtilsJDBC.getConnection();
            statement = connection.createStatement();
            //SELECT * FROM `users` WHERE `name`='上官婉儿' AND `password`='123456';
            String sql="SELECT * FROM `users` where `name`='"+name+"' AND `password`='"+password+"'";
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
