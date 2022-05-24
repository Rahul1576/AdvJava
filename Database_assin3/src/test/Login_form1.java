package test;
import java.util.*;
import java.sql.*;
public class Login_form1 {
	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
			
			Scanner s=new Scanner(System.in);
			System.out.println("===Choice====");
			System.out.println("1.Register\n2.Login\n3.View Profile");
			System.out.println("Enter Choice");
			int choice=Integer.parseInt(s.nextLine());
			switch(choice)
			{
				case 1:
				PreparedStatement ps1=con.prepareStatement("insert into userregis44 values(?,?,?,?,?,?,?)");
				System.out.println("Enter User Name");
				String Uname=s.nextLine();
				System.out.println("Enter Password");
				String pWord=s.nextLine();
				System.out.println("Enter FirstName");
				String fName=s.nextLine();
				System.out.println("Enter LastName");
				String lName=s.nextLine();
				System.out.println("Enter Address");
				String addr=s.nextLine();
				System.out.println("Enter Mailid");
				String mId=s.nextLine();
				System.out.println("Enter Mobile");
				long phNo=Long.parseLong(s.nextLine());
				
				ps1.setString(1,Uname);
				ps1.setString(2,pWord);
				ps1.setString(3,fName);
				ps1.setString(4,lName);
				ps1.setString(5,addr);
				ps1.setString(6,mId);
				ps1.setLong(7,phNo);
				
				int k=ps1.executeUpdate();
				if(k>0)
				{
					System.out.println("Registration Successfull");
				}
				break;
			
			case 2:
				PreparedStatement ps2=con.prepareStatement
				("select * from userregis44 where Uname=? and pWord=?");
				System.out.println("Enter the UserName");
				String Uname1=s.nextLine();
				System.out.println("Enter the Password");
				String pWord1=s.nextLine();
				
				ps2.setString(1,Uname1);
				ps2.setString(2,pWord1);
				
				ResultSet rs1=ps2.executeQuery();//execution
				//uncomplete;
				if(rs1.next())
				{
					System.out.println("Login Successfull");
					System.out.println("Welcome User:"+rs1.getString(3));
				}
				else {
					System.out.println("Invalid Login process");
				}
				break;
			case 3:
				PreparedStatement ps3=con.prepareStatement
				("select * from userregis44 where Uname=? and pWord=?");
				System.out.println("Enter the UserName");
				String Uname2=s.nextLine();
				System.out.println("Enter the Password");
				String pWord2=s.nextLine();
				
				ps3.setString(1,Uname2);
				ps3.setString(2,pWord2);
				
				ResultSet rs2=ps3.executeQuery();//execution
				if(rs2.next())
				{
					System.out.println("UserDetails");
					System.out.println("FirstName:"+rs2.getString(3)+
							"\nLastName:"+rs2.getString(4)+"\nAddress:"+rs2.getString(5)+
							"\nMailId:"+rs2.getString(6)+"\nPhoneNo:"+rs2.getString(7));
				}
				else {
					System.out.println("Invalid Login Proces");
				}
				break;
				
				default:
					System.out.println("Invalid Choice");
		}//end switch
		s.close();
		}//end of try
		catch(Exception e) {e.printStackTrace();}
	}
}