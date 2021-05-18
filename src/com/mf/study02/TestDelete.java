package com.mf.study02;

import com.mf.utils.UtilsJDBC;

import java.sql.*;

/**
 * @author mf
 * @create 2021-05-18-9:33
 */
public class TestDelete {
    public static void main(String[] args) throws SQLException {
        Connection conn = UtilsJDBC.getConnection();

        String sql="DELETE FROM `users` WHERE `name`=?;";
        PreparedStatement st = conn.prepareStatement(sql);

        st.setString(1,"韩信");
        int i = st.executeUpdate();
        if(i>0) System.out.println("删除成功");
        else System.out.println("删除失败");
        UtilsJDBC.releaseConnection(conn, st, null);
    }
}
