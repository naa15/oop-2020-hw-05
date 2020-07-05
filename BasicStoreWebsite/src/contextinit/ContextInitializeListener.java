package contextinit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ManagerPackage.ProductManager;

/**
 * Application Lifecycle Listener implementation class ContextInitializeListener
 *
 */
public class ContextInitializeListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextInitializeListener() {
        
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        arg0.getServletContext().setAttribute("manager", new ProductManager());
    }
	
}
