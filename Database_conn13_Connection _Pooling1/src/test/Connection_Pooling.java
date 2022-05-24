package test;
import java.util.*;
import java.sql.*;
public class Connection_Pooling {
       public String url,uName,pWord;//Instance variables memory in object
       public Connection_Pooling(String url,String uName,String pWord)
       {
    	   this.url=url;
    	   this.uName=uName;
    	   this.pWord=pWord;
    }
       public Vector<Connection>v=new Vector<Connection>();
       //vector holding connection objects..
       public void createConnection()
       {
    	   try {
    	    	Class.forName("oracle.jdbc.driver.OracleDriver");
         while(v.size()<5)
         {
        	 System.out.println("Connection pooling is not Full");
      		Connection con=DriverManager.getConnection(url,uName,pWord);
      		v.add(con);//Adding connection to vector,
      		 System.out.println(con);
         }
         if(v.size()==5)
         {
        	 System.out.println("Connection pooling is Full");
         }
    	   }catch(Exception e) {e.printStackTrace();}
       }
       public synchronized Connection useConnection()//getting yhe connection from the pool
       {
    	   Connection con=v.firstElement();//getting the first connection
    	v.removeElementAt(0);  //removing the connection from pool
    	return con;
       }
       public synchronized void addConnectionToPool(Connection con)
       {
    	 v.addElement(con);
    	 System.out.println("Connection added back to the pool Succeessfully");
       }
}
