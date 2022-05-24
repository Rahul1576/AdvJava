package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/first")
public class First_Servlet implements Servlet
{
	public void init(ServletConfig sc)
	{
		//Nocode
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("Welcome to Servlet the page is live");
		pw.println("\nWelcome to Servlet");
		pw.println("\nWelcome to Servlet");
		pw.println("\nWelcome to Servlet");
		pw.println("\nWelcome to Servlet oops!");
		pw.println("\nWelcome to Servlet");
		pw.println("\nWelcome to Servlet oops!");
	}
	public void destroy()
	{
		//Nocode
	}
	public ServletConfig getServletConfig()
	{
		return this.getServletConfig();
	}
	public String getServletInfo()
	{
		return "First_Servlet";
	}
}