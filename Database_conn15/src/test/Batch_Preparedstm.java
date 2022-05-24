package test;
import java.sql.*;
public class Batch_Preparedstm {
	public static void main(String[] args) {
       try {
    	   Class.forName("oracle.jdbc.driver.OracleDriver");
    		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
    		PreparedStatement ps=con.prepareStatement("insert into book44 values(?,?,?,?,?)");
    		ps.setString(1, "A222");
    		ps.setString(2, "c++");
    		ps.setString(3, "B-swamy");
    		ps.setFloat(4, 345);
    		ps.setInt(5,10);
    		ps.addBatch();
    		
    		ps.setString(1, "A666");
    		ps.setString(2, "c#");
    		ps.setString(3, "pqr");
    		ps.setFloat(4, 3454);
    		ps.setInt(5,12);
    		ps.addBatch();
    		int k[]=ps.executeBatch();
    		for(int i=0;i<k.length;i++)
    		{
    			System.out.println("Updated Successfully");
    		}
    		ps.clearBatch();
    		
       }catch(Exception e){ e.printStackTrace();}
	}

}
