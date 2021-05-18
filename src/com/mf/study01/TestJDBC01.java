package com.mf.study01;

import java.sql.*;

/**
 * @author mf
 * @create 2021-05-17-22:22
 */
public class TestJDBC01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");//里面是一个静态代码块，直接加载
        //2.用户信息和url
        String url="jdbc:mysql://localhost:3306/tb_jdbc?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        String username="root";
        String password="123456";
        //3.连接成功，数据库对象  connection 代表数据库
        Connection connection = DriverManager.getConnection(url,username,password);
        //4.执行sql对象 statement执行sql的对象
        Statement statement = connection.createStatement();
        //5.执行sql,可能存在结果，查看返回结果
        String sql="SELECT * FROM `users`;";
        ResultSet resultSet = statement.executeQuery(sql);//返回结果集
        while (resultSet.next()){
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("name"));
            System.out.println("password=" + resultSet.getObject("password"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birthday=" + resultSet.getObject("birthday"));
            System.out.println("=========================================================");
        }

        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }

}
