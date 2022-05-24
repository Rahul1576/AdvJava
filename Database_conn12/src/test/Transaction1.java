package test;
import java.util.*;
import java.sql.*;
public class Transaction1 {
	public static void main(String[] args)
	{
		try {
		Scanner s=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##javadb1","javadb1");
		System.out.println("Commit statuc:"+con.getAutoCommit());
		con.setAutoCommit(false);
		System.out.println("Commit statuc:"+con.getAutoCommit());
		PreparedStatement ps1=con.prepareStatement("select * from bank44 where accno=?");
		PreparedStatement ps2=con.prepareStatement("update bank44 set balance=balance+? where accno=?");
		Savepoint sp=con.setSavepoint();
		System.out.println("Enter the homeAccno(raj)");
		long hAccno=s.nextLong();
		ps1.setLong(1, hAccno);
		ResultSet rs1=ps1.executeQuery();
		if(rs1.next())
		{
			float bal=rs1.getFloat(3);
			System.out.println("Enter the bAccno(alex)");
			long bAccno=s.nextLong();
			
			ps1.setLong(1, bAccno);
			ResultSet rs2=ps1.executeQuery();
			if(rs2.next())
			{
				System.out.println("Enter amount to transfer");
				int amt=s.nextInt();
				if(amt<=bal)
				{
					ps2.setInt(1,-amt);
					ps2.setLong(2,hAccno);
					int p=ps2.executeUpdate();
					ps2.setInt(1,amt);
					ps2.setLong(2,bAccno);
					int q=ps2.executeUpdate();
					if(p==1&&q==1)
					{
						con.commit();
						System.out.println("Transaction Successfull");

					}
					else {
						con.rollback(sp);
						System.out.println("Transaction Failed");

					}
				}
				else {
					System.out.println("Insufficient Balance");
				}

			}else {
				System.out.println("Invalid bAccno");

			}
		}
		else {
			System.out.println("Invalid homeAccno");

		}
		s.close();
		}catch(Exception e) {e.printStackTrace();}
	}

}
