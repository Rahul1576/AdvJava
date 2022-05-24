package test;
import java.sql.*;
import javax.servlet.http.*;
public class LoginDAO 
{
	public UserBean ub=null;
	public UserBean Login(HttpServletRequest req)
	{
	   try {
		Connection con=DBConnection.getcon();
		PreparedStatement ps=con.prepareStatement("select * from userreg44 where uname=? and pword=?");
		   ps.setString(1, req.getParameter("uname"));
		   ps.setString(2, req.getParameter("pword"));
		   ResultSet rs=ps.executeQuery();
		   if(rs.next())
		   {
			   ub=new UserBean();//Bean Object
			   ub.setuName(rs.getString(1));
			   ub.setpWord(rs.getString(2));
			   ub.setfName(rs.getString(3));
			   ub.setlName(rs.getString(4));
			   ub.setAddr(rs.getString(5));
			   ub.setmId(rs.getString(6));
			   ub.setPhno(rs.getLong(7));
		   }
		}catch(Exception e) {e.printStackTrace();}
		return ub;
	}
}