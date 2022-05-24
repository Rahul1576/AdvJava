package test;
import java.io.*;
import javax.servlet.*;
public class DisplayFilter implements Filter
{
	public FilterConfig fc;//Instance variable
	public void init(FilterConfig fc)throws ServletException{
		this.fc=fc;
	}
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("Welcome User:"+req.getParameter("uname"));
		pw.println("<br>FilterConfig");
		pw.println("<br>FilterName:"+fc.getFilterName());
		pw.println("<br>FilterConfig value:"+fc.getInitParameter("a"));
	}
}