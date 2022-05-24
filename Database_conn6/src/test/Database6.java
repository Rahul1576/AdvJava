package test;
import java.util.*;
import java.sql.*;
public class Database6 {
	public static void main(String[] args) {
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the accno");
			long accno=Long.parseLong(s.nextLine());
			System.out.println("Enter the custname");
			String custname=s.nextLine();
			System.out.println("Enter the balance");
			float bal=Float.parseFloat(s.nextLine());
			System.out.println("Enter the acctype");
			String acctype=s.nextLine();
			System.out.println("Enter the address");
			String addr=s.nextLine();
			System.out.println("Enter the mailid");
			String mid=s.nextLine();
			System.out.println("Enter the phone num");
			Long phno=s.nextLong();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
			CallableStatement cs=con.prepareCall("{call CreateAccount44(?,?,?,?,?,?,?)}");
			cs.setLong(1, accno);
			cs.setString(2, custname);
			cs.setFloat(3, bal);
			cs.setString(4,acctype);
			cs.setString(5, addr);
			cs.setString(6, mid);
			cs.setLong(7, phno);
			cs.execute();
			System.out.println("Procedure executed successfully");
			s.close();

		}
		catch(Exception e) {e.printStackTrace();}

	}

}