package test;
import java.util.*;
import java.sql.*;
public class Db_Conn3 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
			Scanner s=new Scanner(System.in);
			System.out.println("===Choice====");
			System.out.println("1.AddBook\n2.ViewBook");
			System.out.println("Enter Choice");
			int choice=Integer.parseInt(s.nextLine());
			switch(choice)
			{
			case 1:
				PreparedStatement ps1=con.prepareStatement("insert into book44 values(?,?,?,?,?)");//compilation
				System.out.println("Enter book code");
				String bCode=s.nextLine();
				System.out.println("Enter book name");
				String bName=s.nextLine();
				System.out.println("Enter book author");
				String bAuthor=s.nextLine();
				System.out.println("Enter book price");
				float bPrice=s.nextFloat();
				System.out.println("Enter book qty");
				int bQty=s.nextInt();
				
				ps1.setString(1,bCode);
				ps1.setString(2,bName);
				ps1.setString(3,bAuthor);
				ps1.setFloat(4,bPrice);
				ps1.setInt(5,bQty);
				int k=ps1.executeUpdate();//execution
				if(k>0)
				{
					System.out.println("Data inserted Successfully");
		
				}
				break;
				
			case 2:
				PreparedStatement ps2=con.prepareStatement("select * from book44");
				ResultSet rs=ps2.executeQuery();//execution
				
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+
							"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
				}
				
			}
		}
		catch(Exception e) {e.printStackTrace();}

	}

}
