package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebFilter("/log")
public class LoginFilter implements Filter
{
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String fName=new LoginDAO().login(req);
		if(fName==null)
		{
			pw.println("Invalid Login Process<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}else {
			req.setAttribute(fName, fName);
			//Adding attribute to request
			chain.doFilter(req, res);//Linking Servlet Program
		}
	}
}