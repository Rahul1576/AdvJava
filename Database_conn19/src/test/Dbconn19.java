package test;
import java.sql.*;
public class Dbconn19 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
			DatabaseMetaData dmd=con.getMetaData();//metadata object
			System.out.println("DriverManager:"+dmd.getDriverName());
			PreparedStatement ps=con.prepareStatement("select empno,empname from emp44 where empno=?");
			ps.setString(1,"R1521");
			ParameterMetaData pmd=ps.getParameterMetaData();//metadata object
			System.out.println("Count of Parameters:"+pmd.getParameterCount());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			}
			ResultSetMetaData rsmd=rs.getMetaData();//metadata object
			System.out.println("Columns count:"+rsmd.getColumnCount());
			
		}catch(Exception e) {e.printStackTrace();}
	}

}
