package mysql;

import java.sql.*;
import java.util.UUID;

/**
 * @Description jdbc批量插入百万条数据
 * @Author leslie
 * @Date 2022/7/14 18:48
 **/
public class ConnectMysql {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        //加载数据库驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        conn.setAutoCommit(false);
        //批量插入数据
        PreparedStatement pstmt = conn.prepareStatement("insert into math(result) values(?)");
        for (int i = 1; i <= 100000; i++) {
            pstmt.setString(1,getUUID());
            pstmt.executeUpdate();
        }
        conn.commit();
        pstmt.close();
        conn.close();
        long end = System.currentTimeMillis();
        System.out.println("插入数据完成");
        System.out.println("用时" + (end - start)/1000 + "秒");

    }

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
