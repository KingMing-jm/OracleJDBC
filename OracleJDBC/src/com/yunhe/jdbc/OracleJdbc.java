package com.yunhe.jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.Random;

/**
 * @author Administrator
 */
public class OracleJdbc {
    @Test
    public void query() throws ClassNotFoundException, SQLException {
        //Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
        String sql = "select * from DEPT";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String deptNo = rs.getString(1);
            String dName = rs.getString(2);
            String loc = rs.getString(3);
            System.out.println(deptNo+dName+loc);
        }
        rs.close();
        ps.close();
        connection.close();
    }

    @Test
    public void addCity() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
        String sql = "insert into t_user values(seq_user.nextval,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        String username="";
        int age=1;
        String[] citys={"北京","上海","杭州","郑州","天津","重庆","宁波","洛阳","西安","兰州"};
        String city="";
        for(int i=0;i<10000;i++){
            username="user"+i;
            age=new Random().nextInt(100);
            city=citys[new Random().nextInt(10)];
            ps.setString(1,username);
            ps.setInt(3,age);
            ps.setString(2,city);
            ps.executeUpdate();
        }

    }
}
