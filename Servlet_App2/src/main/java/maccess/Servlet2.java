 package maccess;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/dis")
public class Servlet2 implements Servlet
{
	public void init(ServletConfig sc)throws javax.servlet.ServletException
	{
		//Nocode
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String pC=req.getParameter("pcode");
		String pN=req.getParameter("pname");
	    float pP=Float.parseFloat(req.getParameter("pprice"));
	    int pQ=Integer.parseInt(req.getParameter("pqty"));
	    pw.print("==ProductDetails==");
	    pw.print("<br>PCode:"+pC);
	    pw.print("<br>Pname:"+pN);
	    pw.print("<br>Pprice:"+pP);
	    pw.print("<br>Pqty:"+pQ);
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
		return "Second_Servlet";
	}
}
