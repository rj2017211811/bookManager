package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBtool {
	private static Connection conn=null;
	
	//获取连接
	public static Connection getConnection()
	{
		try {
			if(conn==null||conn.isClosed())
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmanager?useSSL=false","root","123456");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmanager?serverTimezone" +

                            "=UTC&characterEncoding=utf-8&useSSL=false","root","123456");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection closeConnection()
	{
	
		try {
			if(conn != null && !conn.isClosed()){
				conn.close();
				conn = null;
				}
		    }catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
