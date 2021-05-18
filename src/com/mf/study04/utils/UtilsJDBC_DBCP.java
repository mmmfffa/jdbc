package com.mf.study04.utils;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author mf
 * @create 2021-05-18-8:40
 */
public class UtilsJDBC_DBCP {

    static DataSource dataSource =null;
    static {
        try {
            InputStream is = UtilsJDBC_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");//拿到流
            Properties properties = new Properties();
            properties.load(is);
            //创建数据源  工厂模式
            dataSource = BasicDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //1.获取连接
    public  static Connection getConnection() throws SQLException {
          return  dataSource.getConnection();
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
