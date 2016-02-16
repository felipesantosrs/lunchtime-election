package entity;

import java.util.Date;

public class Election {
	
	private Date electionDate;
	private Restaurant restaurantElected;
	
	/**
	 * @param electionDate
	 * @param restaurantElected
	 */
	public Election(Date electionDate, Restaurant restaurantElected) {
		super();
		this.electionDate = electionDate;
		this.restaurantElected = restaurantElected;
	}
	/**
	 * @return the electionDate
	 */
	public final Date getElectionDate() {
		return electionDate;
	}
	/**
	 * @param electionDate the electionDate to set
	 */
	public final void setElectionDate(Date electionDate) {
		this.electionDate = electionDate;
	}
	/**
	 * @return the restaurantElected
	 */
	public final Restaurant getRestaurantElected() {
		return restaurantElected;
	}
	/**
	 * @param restaurantElected the restaurantElected to set
	 */
	public final void setRestaurantElected(Restaurant restaurantElected) {
		this.restaurantElected = restaurantElected;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((electionDate == null) ? 0 : electionDate.hashCode());
		result = prime * result + ((restaurantElected == null) ? 0 : restaurantElected.hashCode());
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
		Election other = (Election) obj;
		if (electionDate == null) {
			if (other.electionDate != null)
				return false;
		} else if (!electionDate.equals(other.electionDate))
			return false;
		if (restaurantElected == null) {
			if (other.restaurantElected != null)
				return false;
		} else if (!restaurantElected.equals(other.restaurantElected))
			return false;
		return true;
	}
	
	
	
	

}
