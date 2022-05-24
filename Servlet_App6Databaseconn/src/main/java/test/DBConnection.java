package test;/* Singleton class design pattern*/
import java.sql.*;
public class DBConnection 
{
	private static Connection con=null;
	private DBConnection() {}
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
            
		
		}catch(Exception e) {e.printStackTrace();}
		}
	public static Connection getCon() {
		return con;
	}

}
