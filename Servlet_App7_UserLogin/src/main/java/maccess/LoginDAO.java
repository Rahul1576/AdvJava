package maccess;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("reg")
public class LoginDAO extends GenericServlet
{
	public UserBean ub=null;
	public RegisterDAO id=null;
	public void init() throws ServletException{
		ub=new UserBean();
		id=new RegisterDAO();
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		ub.setUname(req.getParameter("uname"));
		ub.setPword(req.getParameter("pword"));
		ub.setFname(req.getParameter("fname"));
		ub.setLname(req.getParameter("lname"));
		ub.setAddr(req.getParameter("addr"));
		ub.setMid(req.getParameter("mid"));
		ub.setPhno(Long.parseLong(req.getParameter("phno")));
		int k=id.register(ub);
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		if(k>0)
		{
			pw.println("Registration Successfull<br>");
			RequestDispatcher rd=req.getRequestDispatcher("register.html");
			rd.include(req, res);
		}	
	}
}