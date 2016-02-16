
package dao;


import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

import entity.Election;
import entity.Restaurant;
import entity.User;
import entity.Vote;

/**
 * Class responsable for population of lists 
 * @author Felipe
 *
 */
public class DataDAO {

	private static LinkedList<User> userList;
	private static LinkedList<Restaurant> restaurantList;
	private static LinkedList<Election> electionList = new LinkedList<Election>();
	private static LinkedList<Vote> votingList = new LinkedList<Vote>();

	/**
	 * Method responsable for population of user
	 */
	public static void createUserData(){
		userList = new LinkedList<User>();
		userList.add(new User(1, "Felipe Rocha", "felipesantos.rs@gmail.com"));
		userList.add(new User(2, "Juliana", "juliana@dbserver"));
		userList.add(new User(3, "Bruna", "bruna@dbserver"));
		userList.add(new User(4, "Greg", "greg@dbserver"));
		userList.add(new User(5, "Pedro", "pedro@dbserver"));
		userList.add(new User(6, "Antonio", "antonio@dbserver"));
		userList.add(new User(7, "Luis", "luis@dbserver"));
		userList.add(new User(8, "Lucas", "lucas@dbserver"));
	}
	
	/**
	 * Method responsable for population of restaurants
	 */
	public static void createRestaurantsData(){
		restaurantList = new LinkedList<Restaurant>();
		restaurantList.add(new Restaurant(1,"Subway"));
		restaurantList.add(new Restaurant(2,"Delmir"));
		restaurantList.add(new Restaurant(3,"Garten Bistro"));
		restaurantList.add(new Restaurant(4,"Bar Famecus"));
		restaurantList.add(new Restaurant(5,"Panorama Gastronômico"));
		restaurantList.add(new Restaurant(6,"Intervalo 50"));
		restaurantList.add(new Restaurant(7,"Delitzzi"));
		restaurantList.add(new Restaurant(8,"Xis da Maria"));
		restaurantList.add(new Restaurant(9,"Bar do 5"));
		restaurantList.add(new Restaurant(10,"Bar do Predio 10"));
	
	}
	
	/**
	 * Method responsable for population of elections
	 */
	public static void createElectionData(){
		electionList = new LinkedList<Election>();
		electionList.add(new Election(java.sql.Date.valueOf(LocalDate.now().minusDays(1)), getRestaurantList().getFirst()));
		electionList.add(new Election(java.sql.Date.valueOf(LocalDate.now().minusDays(2)), getRestaurantList().get(4)));

	}
	
	
	/**
	 * Method responsable for population of votes
	 */
	public static void createVotedData(){
		votingList = new LinkedList<Vote>();
		votingList.add(new Vote(getUserList().get(6), getRestaurantList().get(5), new Date()));
		votingList.add(new Vote(getUserList().get(7), getRestaurantList().get(6), new Date()));
		
	}
	
	

	public static void saveElection(Election election){
		electionList.add(election);
	}
	
	public static void saveVoting(Vote voting){
		votingList.add(voting);
	}
	
	/**
	 * @return the userList
	 */
	public final static LinkedList<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	@SuppressWarnings("static-access")
	public final void setUserList(LinkedList<User> userList) {
		this.userList = userList;
	}

	/**
	 * @return the restaurantList
	 */
	public final static LinkedList<Restaurant> getRestaurantList() {
		return restaurantList;
	}

	/**
	 * @param restaurantList the restaurantList to set
	 */
	@SuppressWarnings("static-access")
	public final void setRestaurantList(LinkedList<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}

	/**
	 * @return the electionList
	 */
	public static final LinkedList<Election> getElectionList() {
		return electionList;
	}

	
	public final void setElectionList(LinkedList<Election> electionList) {
		DataDAO.electionList = electionList;
	}

	/**
	 * @return the votingList
	 */
	public static final LinkedList<Vote> getVotingList() {
		return votingList;
	}

	/**
	 * @param votingList the votingList to set
	 */
	public static final void setVotingList(LinkedList<Vote> votingList) {
		DataDAO.votingList = votingList;
	}
	
	
}
