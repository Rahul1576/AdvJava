 package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/book")
public class Bookdetails implements Servlet
{
	public void init(ServletConfig sc)throws javax.servlet.ServletException
	{
		//Nocode
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String bC=req.getParameter("bcode");
		String bN=req.getParameter("bname");
		String bA=req.getParameter("bauthor");
	    float bP=Float.parseFloat(req.getParameter("bprice"));
	    int bQ=Integer.parseInt(req.getParameter("bqty"));
	    pw.print("==BookDetails==");
	    pw.print("<br>PCode:"+bC);
	    pw.print("<br>Pname:"+bN);
	    pw.print("<br>Pprice:"+bA);
	    pw.print("<br>Pprice:"+bP);
	    pw.print("<br>Pqty:"+bQ);
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
		return "Book_Servlet";
	}
}