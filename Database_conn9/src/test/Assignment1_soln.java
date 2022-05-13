package test;
import java.util.*;
import java.sql.*;
public class Assignment1_soln {
	public static void main(String[] args) {
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("enter empid");
			String eid=s.nextLine();
			System.out.println("enter empname");
			String ename=s.nextLine();
			System.out.println("enter empdesign");
			String edesg=s.nextLine();
			System.out.println("enter hno");
			String hno=s.nextLine();
			System.out.println("enter sname");
			String sname=s.nextLine();
			System.out.println("enter city");
			String city=s.nextLine();
			System.out.println("enter pincode");
			int pincode=Integer.parseInt(s.nextLine());
			System.out.println("enter mailid");
			String mid=s.nextLine();
			System.out.println("enter phoneno");
			long phno=s.nextLong();
			System.out.println("enter bsal");
			int bsal=s.nextInt();
			float totsal=bsal+(0.93F*bsal)+(0.63F*bsal);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
			CallableStatement cs=con.prepareCall("{call InsertEmployee44(?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, eid);
			cs.setString(2,ename);
			cs.setString(3, edesg);
			cs.setString(4, hno);
			cs.setString(5,sname);
			cs.setString(6,city);
			cs.setInt(7, pincode);
			cs.setString(8,mid);
			cs.setLong(9, phno);
			cs.setInt(10, bsal);
			cs.setFloat(11, totsal);
			cs.execute();
			System.out.println("Employee details inserted successfully");
			s.close();
			
			
		}catch(Exception e) {e.printStackTrace();}
	}

}
