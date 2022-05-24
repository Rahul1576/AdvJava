package test;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebListener
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener
{
	public void SessionCreated(HttpSessionEvent hse)
	{
		System.out.println("Session created");
	}
	public void SessionDestroyed(HttpSessionEvent hse)
	{
		System.out.println("Session Destroyed");
	}
	public void attributeAdded(HttpSessionBindingEvent hsbe)
	{
		System.out.println("Attribute added to session");
	}
	public void attributeRemoved(HttpSessionBindingEvent hsbe)
	{
		System.out.println("Attribute removed from Session");
	}
}