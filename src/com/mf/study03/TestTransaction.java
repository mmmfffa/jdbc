package com.mf.study03;

import com.mf.utils.UtilsJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author mf
 * @create 2021-05-18-12:03
 */
public class TestTransaction {
    public static void main(String[] args){
       Connection conn =null;
       PreparedStatement st =null;
        try {
            conn = UtilsJDBC.getConnection();
            //关闭事务自动提交,关闭后自动开启事务
            conn.setAutoCommit(false);
            String sql1="UPDATE `account` SET `money`=`money`-500 WHERE `name`='A'";
            String sql2="UPDATE `account` SET `money`=`money`+500 WHERE `name`='B'";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();
            //模拟失败
            int i=1/0;
            st = conn.prepareStatement(sql2);
            st.executeUpdate();
            conn.commit();
            System.out.println("提交成功");
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                assert conn != null;
                conn.rollback();//默认失败回滚，可以不设置
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("操作失败");
            e.printStackTrace();
        } finally {
            UtilsJDBC.releaseConnection(conn,st,null);
        }
    }
}
