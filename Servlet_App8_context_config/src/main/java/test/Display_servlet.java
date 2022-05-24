package test;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class Display_servlet extends GenericServlet
{
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("welcome user:"+req.getParameter("name")+"<br>");
		pw.println("servlet_Context<br>");
		
		ServletContext sct=this.getServletContext();
		//Accessing servletContext object reference
		
		pw.println("Servlet_info:"+sct.getServerInfo()+"<br>");
		pw.println("Context value:"+sct.getInitParameter("a")+"<br>");
		pw.println("Servlet config<br>");
		ServletConfig sc=this.getServletConfig();
		//Accessing servlet_config object reference
		
		pw.println("Config value:"+sc.getInitParameter("b"));
		pw.println("Servlet name:"+sc.getServletName()+"<br>");
	}
}