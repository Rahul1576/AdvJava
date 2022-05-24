package test;
import java.sql.*;
public class BatchProcessing_statement {
	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
		Statement stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=stm.executeQuery("select * from emp44");
		rs.afterLast();//cursor indicating after the last row
		while(rs.previous())
		{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
		}
		}catch(Exception e) {e.printStackTrace();}
	}

}
