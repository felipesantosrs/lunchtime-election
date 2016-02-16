/**
 *
 * Felipe
 */
package business;

import java.time.LocalDate;

import org.junit.Test;

import dao.DataDAO;
import dao.VoteDAO;
import entity.Election;
import entity.Vote;
import junit.framework.TestCase;
import util.DateUtil;

/**
 * @author Felipe
 *
 */
public class ElectionBusinessTest extends TestCase {


	@Test
	public void testMostVotedRestaurantToday() {
		firstStep();
		todayElection();
		ElectionBusiness b = new ElectionBusiness();
		// create election
		Election election = b.mostVotedRestaurantToday();		
		assertEquals(election.getRestaurantElected().getRestaurantName(), DataDAO.getRestaurantList().get(0).getRestaurantName());
	}


	private void todayElection() {
		VoteDAO dao = new VoteDAO();
		dao.saveVoting(new Vote(DataDAO.getUserList().get(0), DataDAO.getRestaurantList().get(0), DateUtil.asDate(LocalDate.now())));
		dao.saveVoting(new Vote(DataDAO.getUserList().get(1), DataDAO.getRestaurantList().get(0), DateUtil.asDate(LocalDate.now())));
		dao.saveVoting(new Vote(DataDAO.getUserList().get(2), DataDAO.getRestaurantList().get(1), DateUtil.asDate(LocalDate.now())));
	}


	private void firstStep() {
		
		DataDAO.createRestaurantsData();
		DataDAO.createUserData();
		DataDAO.createVotedData();
		DataDAO.createElectionData();
	}


	@Test
	public void testValidUserVotedToday() {
		firstStep();
		todayElection();
		ElectionBusiness b = new ElectionBusiness();
		assertEquals(false, b.validUserVotedToday(DataDAO.getUserList().get(0)));
		assertEquals(true, b.validUserVotedToday(DataDAO.getUserList().get(3)));
	}


	@Test
	public void testRestaurantListNotVotedWeek() {
		firstStep();
		todayElection();
		ElectionBusiness b = new ElectionBusiness();
		assertTrue(b.restaurantListNotVotedWeek().contains(DataDAO.getRestaurantList().get(3)));
		
		
	}

}
