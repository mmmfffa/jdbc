package com.mf.study04;

import com.mf.study04.utils.UtilsJDBC_DBCP;
import com.mf.utils.UtilsJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author mf
 * @create 2021-05-18-9:06
 */
public class TestDBCP {
    public static void main(String[] args) throws SQLException {
        Connection conn = UtilsJDBC_DBCP.getConnection();
        //区别
        String sql = "INSERT INTO `users`(`id`,`name`,`password`,`email`,`birthday`) VALUES(?,?,?,?,?)";
        PreparedStatement st = conn.prepareStatement(sql);//预编译sql,先写sql，不执行
        //手动赋值
        st.setInt(1,1);
        st.setString(2,"韩信");
        st.setString(3,"2222");
        st.setString(4,"@126.com");
        //注意点：sql.Data   util.Data
        //new java.util.Date().getTime()获得时间戳
        st.setString(5, String.valueOf(new Date(new java.util.Date().getTime())));
        int i = st.executeUpdate();
        if(i>0) System.out.println("插入成功");
        else System.out.println("插入失败");
        UtilsJDBC_DBCP.releaseConnection(conn,st,null);
    }
}
