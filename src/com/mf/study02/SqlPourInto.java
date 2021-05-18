package com.mf.study02;

import com.mf.utils.UtilsJDBC;

import java.sql.*;

/**
 * @author mf
 * @create 2021-05-18-10:49
 */
public class SqlPourInto {
    public static void main(String[] args) throws SQLException {
       // login("上官婉儿","3344");
       login("'' or 1=1","'' or 1=1");
    }
    public static void login(String name,String password) throws SQLException {
        Connection conn = UtilsJDBC.getConnection();

        String sql="SELECT * FROM `users` where `name`=? AND `password`=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1,name);
        st.setString(2,password);
        ResultSet res = st.executeQuery();

        while (res.next()){
            System.out.println("id=" + res.getObject("id"));
            System.out.println("name=" + res.getObject("name"));
            System.out.println("password=" + res.getObject("password"));
            System.out.println("email=" + res.getObject("email"));
            System.out.println("birthday=" + res.getObject("birthday"));
            System.out.println("=========================================================");
        }
        UtilsJDBC.releaseConnection(conn, st, res);
    }
}
