package test;
import java.util.*;
import java.sql.*;
public class Assignmenr_soln3 {
	public static void main(String[] args) {
	try {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter empid");
		String eId=s.nextLine();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
		CallableStatement cs=con.prepareCall("{call?:=getTotalsal44(?)}");
		cs.registerOutParameter(1,Types.FLOAT);
		cs.setString(2, eId);
		cs.execute();
		System.out.println("Enter empid:"+eId);
		System.out.println("Totalsal:"+cs.getFloat(1));
		s.close();
	}catch(Exception e) {e.printStackTrace();}
	}
}
