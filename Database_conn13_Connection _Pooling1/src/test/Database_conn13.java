package test;
import java.sql.*;
public class Database_conn13 {
	public static void main(String[] args) {
      try {
  		Connection_Pooling cp=new Connection_Pooling
  				("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
      cp.createConnection();//getting five connection objects;
      System.out.println("Pool size:"+cp.v.size());
      System.out.println("===User-1===");
      Connection con=cp.useConnection();
      System.out.println("user using:"+con);
      System.out.println("Pool size:"+cp.v.size());
      System.out.println("User-1 returned the connection");
      cp.addConnectionToPool(con);//adding connection
      System.out.println("Pool size:"+cp.v.size());
      System.out.println("connection from the pool");
      cp.v.forEach((k)->{
    	  System.out.println(k);
      });
      }catch(Exception e) {e.printStackTrace();}
	}

}
