package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebListener
public class RequestListener implements ServletRequestListener
{
	public void requestInitialized(ServletRequestEvent sre)
	{
		System.out.println("Request object Initialized");
	}
	public void requestDestroyed(ServletRequestEvent sre)
	{
		System.out.println("Request Object Destroyed");
	}
}
