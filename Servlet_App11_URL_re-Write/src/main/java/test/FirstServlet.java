package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/first")
public class FirstServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ProductBean pb=new RetrieveDAO().retrieve(req);
		if(pb==null)
		{
			pw.println("Invalid ProductCode<br>");
			RequestDispatcher rd=req.getRequestDispatcher("input.html");
			rd.include(req,res);
		}else
		{
			pw.println("<a href='second?pcode="+pb.getCode()+"&pname="+pb.getName()+"&pprice="+pb.getPrice()+"&pqty="+pb.getQty()+"'>ViewProductDetails</a>");
		}
	}
}