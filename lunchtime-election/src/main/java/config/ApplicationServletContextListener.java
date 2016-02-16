/**
 *
 * Felipe
 */
package config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.DataDAO;
import quartz.Agenda;

/**
 * Class Listener when it is load applicantion in the coutainer 
 * @author Felipe
 *
 */
public class ApplicationServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		System.out.println("ServletContextListener destroyed");

	}
	/**
	 * This method that is load when the container in
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextListener started");
		DataDAO.createRestaurantsData();
		DataDAO.createUserData();
		DataDAO.createElectionData();
		DataDAO.createVotedData();
		try {
			Agenda.init();
		} catch (Exception e) {
			System.out.println("Error inicialize quartz");
		}

	}

}
