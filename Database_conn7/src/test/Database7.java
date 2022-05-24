package test;
import java.util.*;
import java.sql.*;
public class Database7 {
	public static void main(String[] args) {
     try {
    	 Scanner s=new Scanner(System.in);
    	 System.out.println("Enter the accno");
    	 long accno=s.nextLong();
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
			CallableStatement cs=con.prepareCall("{call retrievedetails44(?,?,?,?,?,?,?)}");
			cs.setLong(1,accno);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3,Types.FLOAT);
			cs.registerOutParameter(4,Types.VARCHAR);
			cs.registerOutParameter(5,Types.VARCHAR);
			cs.registerOutParameter(6,Types.VARCHAR);
			cs.registerOutParameter(7,Types.BIGINT);
			cs.execute();
			System.out.println("procedure executed successfully");
			System.out.println("Accno:"+accno);
			System.out.println("custname:"+cs.getString(2));
			System.out.println("balance:"+cs.getFloat(3));
			System.out.println("acctype:"+cs.getString(4));
			System.out.println("address:"+cs.getString(5));
			System.out.println("maild:"+cs.getString(6));
			System.out.println("phno:"+cs.getLong(7));
            s.close();
     }catch(Exception e) {e.printStackTrace();}
	}
}
//this execute when we enter bank account number which previously entered;