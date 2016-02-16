/**
 *
 * Felipe
 */
package quartz;

import org.apache.commons.mail.EmailException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import business.ElectionBusiness;
import config.SendEmail;
import dao.ElectionDAO;
import dao.UserDAO;
import entity.Election;

/**
 * @author Felipe
 *
 */
public class TaskQuartz implements Job {

	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		ElectionBusiness electionBusiness = new ElectionBusiness();
		SendEmail email = new SendEmail();
		UserDAO userDAO = new UserDAO();
		Election election = electionBusiness.mostVotedRestaurantToday();
		// election done
		ElectionDAO.saveElection(election);
		try {
			email.send(userDAO.userList(), election.getRestaurantElected().getRestaurantName());
		} catch (EmailException e) {
			System.out.println("error sends email: " + e);
		}
		
	}

	
	
	
}
