package test;
import java.util.*;
import java.sql.*;
import javax.sql.rowset.*;
@SuppressWarnings("unused")
public class Row_set {
	public static void main(String[] args) {
     try {
    	 Scanner s=new Scanner(System.in);
 		Class.forName("oracle.jdbc.driver.OracleDriver");
 		RowSetFactory rsf=RowSetProvider.newFactory();//roe set factory object
 		System.out.println("==choice-==");
		System.out.println("1.jdbcRowSet\n2.CatchedRowset");
		System.out.println("Enter the choice");
 		int choice=s.nextInt();
 		switch(choice)
 		{
 		case 1:
 			JdbcRowSet jrs=rsf.createJdbcRowSet();//jdbc rowset object
 			jrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
 			jrs.setUsername("c##javadb1");
 			jrs.setPassword("javadb1");
 			jrs.setCommand("Select * from emp44");
 			jrs.execute();
 			while(jrs.next())
 			{
 				System.out.println(jrs.getString(1)+"\t"+jrs.getString(2)+"\t"+jrs.getString(3)+jrs.getInt(4));
 				
 			}
 			break;
 		case 2:
 			CachedRowSet crs=rsf.createCachedRowSet();//cached row set object
 			crs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
 			crs.setUsername("c##javadb1");
 			crs.setPassword("javadb1");
 			crs.setCommand("Select * from book44");
 			crs.execute();
 			while(crs.next())
 			{
 				System.out.println(crs.getString(1)+"\t"+crs.getString(2)+"\t"+crs.getString(3)+"\t"+crs.getFloat(4)+crs.getInt(5));	
 			}
 			break;
 		default:
 			System.out.println("Invalid choice");
 			break;
 		}
 		s.close();

     }catch(Exception e) {e.printStackTrace();}
	}
}
