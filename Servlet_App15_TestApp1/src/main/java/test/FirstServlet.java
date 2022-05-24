package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/first")
public class FirstServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String uName=req.getParameter("uname");
		String mId=req.getParameter("mid");
		res.sendRedirect("http://localhost:8084/Servlet_App15_TestApp1/second?uname="+uName+"&mid="+mId);
	}
}