package com.mf.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author mf
 * @create 2021-05-18-8:40
 */
//src目录下的文件都可通过反射拿到
public class UtilsJDBC {
    private  static String driver=null;
    private  static String url=null;
    private  static String username=null;
    private  static String password=null;

    static {
        try {
            InputStream is = UtilsJDBC.class.getClassLoader().getResourceAsStream("db.properties");//拿到流
            Properties properties = new Properties();
            properties.load(is);
            driver = properties.getProperty("driver");
            url    = properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
            //驱动只用加载一次
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //1.获取连接
    public  static Connection getConnection() throws SQLException {
      return  DriverManager.getConnection(url,username,password);
    }

    //2.释放连接
    public static void releaseConnection(Connection conn, Statement st, ResultSet res) {

        try {
            if(res!=null) res.close();
            if(st!=null) st.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
