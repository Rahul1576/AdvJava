package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebListener
public class ContextListener implements ServletContextListener
{
	public void ContextInitialized(ServletContextEvent sce)
	{
		System.out.println("Context Object Initialized");
		ServletContext sct=sce.getServletContext();
       System.out.println("ServerInfo:"+sct.getServerInfo());
	}
	public void ContextDestroy(ServletContextEvent sce)
	{
		System.out.println("Context object destroyed");
	}
}