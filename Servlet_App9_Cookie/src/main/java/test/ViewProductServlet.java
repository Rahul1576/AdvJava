package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProductServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();//creating cookies from request
		if(c==null)
		{
			pw.println("Session Expired<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			String fName=c[0].getValue();
			pw.println("page of user:"+fName+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
			pw.println("<br>");
			ArrayList<ProductBean>al=new RetrieveDAO().retrieve();
			if(al.size()==0)
			{
				pw.println("product not available<br>");
			}
			else
			{
				Iterator<ProductBean>it=al.iterator();
				while(it.hasNext())
				{
					ProductBean pb=(ProductBean)it.next();
					pw.println(pb.getCode()+"&nbsp&nbsp"+pb.getName()+"&nbsp&nbsp"+pb.getPrice()
					+"&nbsp&nbsp"+pb.getQty()+"<br>");
					
				}
			}
		}
	}
}