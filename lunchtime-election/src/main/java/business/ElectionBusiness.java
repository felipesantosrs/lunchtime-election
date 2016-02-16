/**
 *
 * Felipe
 */
package business;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.BinaryOperator;

import dao.ElectionDAO;
import dao.RestaurantDAO;
import dao.VoteDAO;
import entity.Election;
import entity.Restaurant;
import entity.User;

/**
 * This class cointain business rules of application
 * @author Felipe
 *
 */
public class ElectionBusiness {
	

	
	
	/**
	 * This method is responsable showing which restaurant was elected 
	 * @return
	 */
	public Election mostVotedRestaurantToday() {
		RestaurantDAO restaurantDAO = new RestaurantDAO();
		List<Restaurant> listRestaurants = restaurantDAO.listRestaurantVotedToday();
		// restaurant most frenquent
		Restaurant restautant = listRestaurants.stream()
		        .reduce(BinaryOperator.maxBy((o1, o2) -> Collections.frequency(listRestaurants, o1) -
		                        Collections.frequency(listRestaurants, o2))).orElse(null);

		return new Election(new Date(), restautant);
	}

	/**
	 * This method is responsable for validation which user there've been voted in the same day
	 * @param user
	 * @return
	 */
	public boolean validUserVotedToday(User user){
			VoteDAO votingDAO = new VoteDAO();
			if (votingDAO.validVotingTodayToUser(user) == null) {
				return true;
			}else{
				return false;
			}
	}
	
	

	/**
	 * Method responsable for showing list of restaurant
	 * @return
	 */
	public List<Restaurant> restaurantListNotVotedWeek(){
		RestaurantDAO restaurantDAO = new RestaurantDAO();
		List<Restaurant> restaurantList = restaurantDAO.restaurantList();
		ElectionDAO electionDAO = new ElectionDAO();
		List<Election> electionLastWeek = electionDAO.lastWeekElection();

		for (Election election : electionLastWeek) {
			restaurantList.remove(election.getRestaurantElected());
		}
		return restaurantList;
		
		
	}
	

}
