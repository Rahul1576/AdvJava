package test;
import java.util.*;
import java.sql.*;
public class demo {
	public static void main(String[] args) 
	{
		try 
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
				,"c##javadb1","javadb1");
		Scanner s=new Scanner(System.in);
		System.out.println("=========choice========");
		System.out.println("1.Add Product\t2.View Product");
		System.out.println("Enter Choice");
		int choice=Integer.parseInt(s.nextLine());
		switch(choice)
		{
		case 1:
				System.out.println("Fill the Details");
				System.out.println("Procuct_Code");
				String pCode=s.nextLine();
				System.out.println("Procuct_name");
				String pName=s.nextLine();
				System.out.println("Procuct_Price");
				int pPrice=s.nextInt();
				System.out.println("Procuct_Qty");
				int pQty=s.nextInt();
				Statement stm1=con.createStatement();
int k=stm1.executeUpdate("insert into product44 values('"+pCode+"','"+pName+"',"+pPrice+","+pQty+")");
			  if(k>0)
			  {
				  System.out.println("-- Data Saved IN DataBase --");
			  }
				con.close();
			break;
			
		case 2:
				Statement stm=con.createStatement();
				ResultSet rs=stm.executeQuery("select * from product44");
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)
					+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
				}
				con.close();
			break;
			default:
				System.out.println("Invalid choice");
		}
    s.close();
    }
    catch(Exception e) {e.printStackTrace();}
	}
}