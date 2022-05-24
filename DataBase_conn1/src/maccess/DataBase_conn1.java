package maccess;
import java.sql.*;
public class DataBase_conn1 {
	public static void main(String[] args) 
	{
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");//step1
		Connection con=DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:orcl","C##DATABASE1","ORACLE1");//step2
		Statement stm=con.createStatement();//step3	
		ResultSet rs=stm.executeQuery("select * from EMP44");//step4
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+
		rs.getString(3)+"\t"+rs.getInt(4));
		}//end of while
		con.close();//step5
		}
		catch(Exception e)
		{e.printStackTrace();}
	}
}
