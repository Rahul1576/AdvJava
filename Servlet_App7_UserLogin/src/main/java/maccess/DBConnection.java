package maccess;
import java.sql.*;
public class DBConnection 
{
	public static Connection con=null;
	private DBConnection() {}
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
			
		}catch(Exception e) {e.printStackTrace();}
	}
	public static Connection getcon()
	{
		return con;
	}
}