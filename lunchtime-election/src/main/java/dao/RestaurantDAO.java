/**
 *
 * Felipe
 */
package dao;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import entity.Restaurant;
import entity.Vote;
import util.DateUtil;

/**
 * Class responsable for consulting restaurants list
 * @author Felipe
 */
public class RestaurantDAO {

	
	/**
	 * Method responsable for showing list of restaurant
	 * @return
	 */
	public List<Restaurant> restaurantList(){
		return DataDAO.getRestaurantList();
	}
		
	/**
	 * Method responsable for list restaurants voted into day	
	 * @return
	 */
	public List<Restaurant> listRestaurantVotedToday(){
		List<Restaurant> restaurantList = new LinkedList<Restaurant>();
		List<Vote> votingList = DataDAO.getVotingList();
		List<Vote> voteListResult = votingList.stream().filter(l -> l.getVotingDate().equals(DateUtil.asDate(LocalDate.now()))).collect(Collectors.toList());;
		voteListResult.forEach(v -> restaurantList.add(v.getRestaurant()) );
		return restaurantList;
		
	}
	

}
