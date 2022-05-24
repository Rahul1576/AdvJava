package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("Product Details<br>");
		pw.println("<br>productCode:"+req.getParameter("pcode"));
		pw.println("<br>productName:"+req.getParameter("pname"));
		pw.println("<br>productPrice:"+req.getParameter("pprice"));
		pw.println("<br>productQty:"+req.getParameter("pqty"));
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		rd.include(req, res);	
	}
}