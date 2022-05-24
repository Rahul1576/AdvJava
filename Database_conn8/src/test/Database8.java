package test;
import java.util.*;
import java.sql.*;
public class Database8 {
	public static void main(String[] args) {
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the custaccno");
			long accno=s.nextLong();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
			CallableStatement cs=con.prepareCall("{call ?:=getBalance444(?)}");
			cs.registerOutParameter(1, Types.FLOAT);
			cs.setLong(2, accno);
			cs.execute();
			System.out.println("Accno:"+accno);
			System.out.println("Balance:"+cs.getFloat(1));
			s.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}