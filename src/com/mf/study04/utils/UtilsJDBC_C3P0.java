package com.mf.study04.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author mf
 * @create 2021-05-18-16:07
 */
public class UtilsJDBC_C3P0 {

    static DataSource dataSource =null;
    static {
        try {
            /*代码版配置
           ComboPooledDataSource combo = new ComboPooledDataSource();
           combo.setDriverClass();
           combo.setUser();
           combo.setPassword();
           combo.setJdbcUrl();
           combo.setMaxPoolSize();
           combo.setMinPoolSize();
            * */

            //创建数据源  工厂模式
            dataSource = new ComboPooledDataSource("MySQL");//配置文件写法

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
