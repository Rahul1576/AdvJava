package test;
import java.sql.*;
public class Batch_Statement {
	public static void main(String[] args) {
     try {
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
 		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
 		Statement stm=con.createStatement();
 		stm.addBatch("insert into emp44 values('A222','ref','me',14000)");
 		stm.addBatch("insert into book44 values('a444','c-java','xyz',1200,12)");
 		stm.addBatch("update emp44 set salary=40000 where empno='R1521'");
 		int k[]=stm.executeBatch();
 		for(int i=0;i<k.length;i++)
		{
			System.out.println("Updated Successfully");
		}
 		stm.clearBatch();
     }catch(Exception e){ e.printStackTrace();}
     
	}

}
