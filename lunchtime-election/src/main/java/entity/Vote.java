package entity;

import java.util.Date;

public class Vote {
	
	private User user;
	private Restaurant restaurant;
	private Date votingDate; 
	
	/**
	 * @param user
	 * @param restaurant
	 * @param votingDate
	 */
	public Vote(User user, Restaurant restaurant, Date votingDate) {
		super();
		this.user = user;
		this.restaurant = restaurant;
		this.votingDate = votingDate;
	}
	/**
	 * @return the user
	 */
	public final User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public final void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the restaurant
	 */
	public final Restaurant getRestaurant() {
		return restaurant;
	}
	/**
	 * @param restaurant the restaurant to set
	 */
	public final void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	/**
	 * @return the votingDate
	 */
	public final Date getVotingDate() {
		return votingDate;
	}
	/**
	 * @param votingDate the votingDate to set
	 */
	public final void setVotingDate(Date votingDate) {
		this.votingDate = votingDate;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((votingDate == null) ? 0 : votingDate.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vote other = (Vote) obj;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (votingDate == null) {
			if (other.votingDate != null)
				return false;
		} else if (!votingDate.equals(other.votingDate))
			return false;
		return true;
	}
	
	
	
	
	
	

}
