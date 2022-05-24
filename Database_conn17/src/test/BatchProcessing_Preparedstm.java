package test;
import java.sql.*;
public class BatchProcessing_Preparedstm {
	public static void main(String[] args) {
     try {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
 		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
 				"c##javadb1","javadb1");
 		PreparedStatement ps=con.prepareStatement("select * from emp44",1004,1007);
 		ResultSet rs=ps.executeQuery();
 		System.out.println("==absolute==");
 		rs.absolute(3);//cursor indicating to row 3
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+
				"\t"+rs.getString(3)+"\t"+rs.getInt(4));
		System.out.println("==relative(+1)");
		rs.relative(+1);//incrementing the cursor position by 1
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+
				"\t"+rs.getString(3)+"\t"+rs.getInt(4));
     }catch(Exception e) {e.printStackTrace();}
  }
}