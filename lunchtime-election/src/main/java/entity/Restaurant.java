package entity;

public class Restaurant {

	private Integer restaurantCode;
	private String restaurantName;

	/**
	 * @param restaurantCode
	 * @param restaurantName
	 * @param restaurantEmail
	 */
	public Restaurant(Integer restaurantCode, String restaurantName) {
		super();
		this.restaurantCode = restaurantCode;
		this.restaurantName = restaurantName;
	}
	

	/**
	 * 
	 */
	public Restaurant() {
		super();
	}


	/**
	 * @return the restaurantCode
	 */
	public final Integer getRestaurantCode() {
		return restaurantCode;
	}

	/**
	 * @param restaurantCode
	 *            the restaurantCode to set
	 */
	public final void setRestaurantCode(Integer restaurantCode) {
		this.restaurantCode = restaurantCode;
	}

	/**
	 * @return the restaurantName
	 */
	public final String getRestaurantName() {
		return restaurantName;
	}

	/**
	 * @param restaurantName
	 *            the restaurantName to set
	 */
	public final void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((restaurantCode == null) ? 0 : restaurantCode.hashCode());
		result = prime * result + ((restaurantName == null) ? 0 : restaurantName.hashCode());
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
		Restaurant other = (Restaurant) obj;
		if (restaurantCode == null) {
			if (other.restaurantCode != null)
				return false;
		} else if (!restaurantCode.equals(other.restaurantCode))
			return false;
		if (restaurantName == null) {
			if (other.restaurantName != null)
				return false;
		} else if (!restaurantName.equals(other.restaurantName))
			return false;
		return true;
	}



}
