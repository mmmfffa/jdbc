package com.mf.study02;

import com.mf.utils.UtilsJDBC;

import java.sql.*;

/**
 * @author mf
 * @create 2021-05-18-9:35
 */
public class TestUpdate {
    public static void main(String[] args) throws SQLException {
        Connection conn = UtilsJDBC.getConnection();

        String sql="UPDATE `users` SET `email`='966' WHERE `name`=?;";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1,"孙尚香");

        int i = st.executeUpdate();
        if(i>0) System.out.println("更新成功");
        else System.out.println("更新失败");
        UtilsJDBC.releaseConnection(conn, st, null);
    }
}
