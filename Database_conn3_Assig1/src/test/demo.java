package test;
import java.sql.*;
import java.util.*;
public class demo
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");//step1
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
					"c##javadb1","javadb1");//step2
		Scanner s=new Scanner(System.in);
		System.out.println("======Choice======");
		System.out.println("1.Add Book\t2.View Book");
		System.out.println("Enter Choice");
		int choice=Integer.parseInt(s.nextLine());
		switch(choice)
		{		
			case 1:
			System.out.println("Enter Book_Code");
			String bCode=s.nextLine();
			System.out.println("Enter Book_name");
			String bName=s.nextLine();
			System.out.println("Enter Book_Author");
			String bAuthor=s.nextLine();
			System.out.println("Enter Book_Price");
			int bPrice=s.nextInt();
			System.out.println("Enter Book_Qty");
			int bQty=s.nextInt();
			
			Statement stm=con.createStatement();//step3
			int k=stm.executeUpdate("insert into book44 values("
					+ "'"+bCode+"','"+bName+"','"+bAuthor+"',"+bPrice+","+bQty+")");

			if(k>0)
			{
				System.out.println("* Data_Inserted Successfully *");
			}
			con.close();
			break;
			
			case 2:
				Statement stm2=con.createStatement();//step3
				ResultSet rs=stm2.executeQuery("select * from book44");
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+
							"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5));
				}
				con.close();//step5
				break;
				
			default:
				System.out.println("Invalid Choice");
	}
		s.close();
	}
		catch(Exception e) {e.printStackTrace();}
	}
}