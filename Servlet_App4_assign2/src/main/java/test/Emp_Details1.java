package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/emp")
public class Emp_Details1 implements Servlet
{
	public void init(ServletConfig sc)throws javax.servlet.ServletException
	{
		//Nocode;
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String eId=req.getParameter("empid");
		String eN=req.getParameter("empname");
		String eD=req.getParameter("empDesg");
		int es=Integer.parseInt(req.getParameter("esal"));
		pw.println("=====Employee Details=====");
		pw.println("EmpId"+eId);
		pw.println("Empname"+eN);
		pw.println("Empdesg"+eD);
		pw.println("Empsal"+es);
	}
	public void destroy()
	{
		//No code;
	}
	public ServletConfig getServletConfig()
	{
		return this.getServletConfig();
	}
	public String getServletInfo()
	{
		return "Display_Servlet";
	} 
}