package test;
import java.util.*;
import java.sql.*;
public class Assignment2_soln {
	public static void main(String[] args) {
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("enter empid");
			String eid=s.nextLine();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
			CallableStatement cs=con.prepareCall("{call retrieveemployee44(?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, eid);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.BIGINT);
			cs.registerOutParameter(10, Types.INTEGER);
			cs.registerOutParameter(11, Types.FLOAT);
			cs.execute();
			System.out.println("Empid:"+eid);
			System.out.println("Empname:"+cs.getString(2));
			System.out.println("Empdesg:"+cs.getString(3));
			System.out.println("hno:"+cs.getString(4));
			System.out.println("sname:"+cs.getString(5));
			System.out.println("city:"+cs.getString(6));
			System.out.println("pincode:"+cs.getInt(7));
			System.out.println("mailid:"+cs.getString(8));
			System.out.println("phno:"+cs.getLong(9));
			System.out.println("bsal:"+cs.getInt(10));
			System.out.println("totsal:"+cs.getFloat(11));
			s.close();
		}catch(Exception e) {e.printStackTrace();}
		}
}