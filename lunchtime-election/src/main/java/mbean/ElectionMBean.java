/**
 *
 * Felipe
 */
package mbean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import business.ElectionBusiness;
import dao.ElectionDAO;
import dao.UserDAO;
import dao.VoteDAO;
import entity.Election;
import entity.Restaurant;
import entity.User;
import entity.Vote;
import util.DateUtil;

/**
 * @author Felipe
 *
 */
@ManagedBean(name = "electionMBean")
@SessionScoped
public class ElectionMBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -40276589321774586L;

	private Vote voting;
	private Election election;
	private User user;
	private String email;

	private Restaurant restaurant;
	private SelectItem restaurantItem;

	private List<Election> lastElectionWeek;

	private List<SelectItem> restaurantItems;

	private Integer restaurantId;

	@PostConstruct
	public void init() {
		ElectionDAO dao = new ElectionDAO();
		election = dao.getElectionDay();
		email = null;

	}
	/**
	 * Action of election a restaurant
	 */
	public void voted() {
		VoteDAO votingDAO = new VoteDAO();
		Vote voting = new Vote(getUser(), getRestaurant(), DateUtil.asDate(LocalDate.now()));
		votingDAO.saveVoting(voting);
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Votação realizada com sucesso",
				"Votação realizada com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		setEmail(null);
	}
	
	/**
	 * Selection boxes 
	 * @param e
	 */
	public void valueChanged(ValueChangeEvent e) {
		restaurantId = Integer.valueOf(e.getNewValue().toString());
		ElectionBusiness business = new ElectionBusiness();
		for (Restaurant restaurant : business.restaurantListNotVotedWeek()) {
			if (restaurant.getRestaurantCode() == getRestaurantId()) {
				setRestaurant(restaurant);
			}
		}
	}

	/**
	 * Action of validation
	 */
	public void validation() {
		if (getEmail() != null && getEmail() != "") {
			UserDAO userDAO = new UserDAO();
			User user = userDAO.getUser(getEmail());
			setUser(user);
			validationUser(user);
		} else {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "E mail obrigatório",
					"E mail obrigatório");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			setEmail(null);
		}
	}
	/**
	 * Validation of user
	 * @param user
	 */
	private void validationUser(User user) {
		if (user != null) {
			validationDataUser(user);
		} else {
			System.err.println("Invalid email");
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "E mail invalido", "E mail invalido");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			setEmail(null);
		}
	}
	
	/**
	 * Validation of data of user
	 * @param user
	 */
	private void validationDataUser(User user) {
		ElectionBusiness business = new ElectionBusiness();
		if (!business.validUserVotedToday(user)) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário já votou hoje","Usuário já votou hoje");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			setEmail(null);
		}else{
			loadRestaurant(user);
		}
	}

	/**
	 * Load comboboxes of user
	 * @param user
	 */
	private void loadRestaurant(User user) {
		ElectionBusiness business = new ElectionBusiness();
		ElectionDAO electionDAO = new ElectionDAO();
		restaurantItems = new ArrayList<SelectItem>();
		for (Restaurant restaurant : business.restaurantListNotVotedWeek()) {
			restaurantItems.add(new SelectItem(restaurant.getRestaurantCode(), restaurant.getRestaurantName()));
		}
		setLastElectionWeek(electionDAO.lastWeekElection());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vote getVoting() {
		return voting;
	}

	public void setVoting(Vote voting) {
		this.voting = voting;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Election> getLastElectionWeek() {
		return lastElectionWeek;
	}

	public void setLastElectionWeek(List<Election> lastElectionWeek) {
		this.lastElectionWeek = lastElectionWeek;
	}

	public List<SelectItem> getRestaurantItems() {
		return restaurantItems;
	}

	public SelectItem getRestaurantItem() {
		return restaurantItem;
	}

	public void setRestaurantItem(SelectItem restaurantItem) {
		this.restaurantItem = restaurantItem;
	}

	/**
	 * @param restaurantItems
	 *            the restaurantItems to set
	 */
	public final void setRestaurantItems(List<SelectItem> restaurantItems) {
		this.restaurantItems = restaurantItems;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
}
