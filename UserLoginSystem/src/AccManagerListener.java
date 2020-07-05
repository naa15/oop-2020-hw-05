

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import accmanager.AccountManager;

/**
 * Application Lifecycle Listener implementation class AccManagerListener
 *
 */
public class AccManagerListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AccManagerListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    	arg0.getServletContext().removeAttribute("accounts");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	AccountManager accounts = new AccountManager();
    	arg0.getServletContext().setAttribute("accs", accounts);
    }
	
}
