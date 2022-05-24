package test;
import java.util.*;
import java.sql.*;
public class Database_5 {
	public static void main(String[] args) 
	{
     try {
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
    	 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
    	 Scanner s=new Scanner(System.in);
    		System.out.println("===Choice====");
			System.out.println("1.UpdateBook\n2.DeleteBook");
			System.out.println("Enter Choice");
			int choice=Integer.parseInt(s.nextLine());
			PreparedStatement ps1=con.prepareStatement("select * from book44 where bCode=?");
		switch(choice)
		{
		case 1:                             
			System.out.println("enter the book code");
			String bCode1=s.nextLine();
			ps1.setString(1, bCode1);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
			{
				System.out.println("old price:"+rs1.getFloat(4));
				System.out.println("old Qty:"+rs1.getInt(5));
				System.out.println("Enter new price");
				float price=Float.parseFloat(s.nextLine());
				System.out.println("Enter new qty");
				int qty=Integer.parseInt(s.nextLine());
				PreparedStatement ps2=con.prepareStatement("update book44 set bprice=? bqty=bqty+? where bcode=?");
				ps2.setFloat(1,price);
				ps2.setInt(2, qty);
				ps2.setString(3,bCode1);
				int k=ps2.executeUpdate();
				if(k>0)
				{
					System.out.println("Book details updated for bCode1");
				}
				else{
					System.out.println("Invalid book code");
				}
			}
	break;
	case 2:
		System.out.println("Enter the bcode");
		String bCode2=s.nextLine();
		ps1.setString(1, bCode2);
		ResultSet rs2=ps1.executeQuery();
		if(rs2.next())
		{
			PreparedStatement ps3=con.prepareStatement("delete from book44 where bcode=?");
			int k=ps3.executeUpdate();
			if(k>0)
			{System.out.println("Book details deleted for"+bCode2);
			}
			else {
				System.out.println("Invalid bookcode");
			}break;
		}
	default:
		System.out.println("Invalid choice");
     }//end of switch
		s.close();
		}catch(Exception e) {e.printStackTrace();}
	}                                        
}
//not run