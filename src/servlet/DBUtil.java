package servlet;

import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBUtil {
    public static final String TABLE_USERINFO = "camera.user";//数据库中的一个表名
    public static final String TABLE_MOVIELIST = "camera.movie";
    public static final String TABLE_MOVIEDATE = "camera.schedule";
    public static final String TABLE_SEAT = "camera.seating";

    public static Connection getConnect() {
        String url = "jdbc:mysql://localhost:3306/Camera?useUnicode=true&characterEncoding=utf-8&userSSL=false";//连接数据库
        Connection connector = null;
        try {
        	try{
        		Class.forName("com.mysql.jdbc.Driver"); 
        	} catch(ClassNotFoundException e){
        		System.out.print("fail");
        		e.printStackTrace();
        	}   	   
            connector = (Connection)DriverManager.getConnection(url, "root", "y19980504");
            System.out.print("success");
        } catch (SQLException e) {
            System.out.print("SQLExeption: " + e.getMessage());
            System.out.print("SQLState: " + e.getSQLState());
            System.out.print("VendorError: " + e.getErrorCode());
        }
        return connector;
    }
}
