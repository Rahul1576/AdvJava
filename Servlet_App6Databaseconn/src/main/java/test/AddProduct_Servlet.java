package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProduct_Servlet extends GenericServlet{

	public ProductBean pb=null;//Instance variable
	public InsertDAO id=null;//instance variable
	
	public void init()throws ServletException{
		pb=new ProductBean();
		id=new InsertDAO();
	}
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
		pb.setCode(req.getParameter("pcode"));
		pb.setName(req.getParameter("pname"));
		pb.setPrice(Float.parseFloat(req.getParameter("pprice")));
		pb.setQty(Integer.parseInt(req.getParameter("pqty")));
		int k=id.insert(pb);//bean object as parameter
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		if(k>0)
		{
			pw.println("Product Added Successfully<br>");
			RequestDispatcher rd=req.getRequestDispatcher("input.html");
			rd.include(req,res);
		}	
	}
}