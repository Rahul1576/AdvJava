package test;
import java.sql.*;
import java.util.*;
public class Database_conn2 {
	public static void main(String[] args) 
	{
		try {
		     Scanner s=new Scanner(System.in);
		     System.out.println("Enter Empno");
		     String eNo=s.nextLine();
		     System.out.println("Enter EmpName");
		     String eName=s.nextLine();
		     System.out.println("Enter EmpDesg");
		     String eDesg=s.nextLine();
		     System.out.println("Enter EmpBsal");
		     String eBsal=s.nextLine();
	    	
		Class.forName("oracle.jdbc.driver.OracleDriver");//step1
		Connection con=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:orcl",
						
				"c##javadb1","javadb1");//step2
		Statement stm=con.createStatement();//step3
		int k=stm.executeUpdate("insert into emp44 values('"+eNo+"','"+eName+"',"
				+ "'"+eDesg+"',"+eBsal+")");
		if(k>0)
		{
			System.out.println("Details Inserted Successfully");
		}
		con.close();//step5
		s.close();
		}	
		catch(Exception e) {e.printStackTrace();}
	}
}