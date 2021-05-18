package com.mf.study02;

import com.mf.utils.UtilsJDBC;

import java.sql.*;

/**
 * @author mf
 * @create 2021-05-18-9:38
 */
public class TestQuery {
    public static void main(String[] args) throws SQLException {
        Connection conn = UtilsJDBC.getConnection();

        String sql="SELECT * FROM `users` where `id`>=?;";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1,2);
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
