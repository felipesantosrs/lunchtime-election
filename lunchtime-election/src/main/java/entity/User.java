package entity;

public class User {
	
	private Integer userCode;
	private String userName;
	private String userEmail;
	
	
	
	/**
	 * @param userName
	 * @param userEmail
	 */
	public User(Integer userCode, String userName, String userEmail) {
		super();
		this.userCode = userCode;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	
	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @return the userCode
	 */
	public final Integer getUserCode() {
		return userCode;
	}
	/**
	 * @param userCode the userCode to set
	 */
	public final void setUserCode(Integer userCode) {
		this.userCode = userCode;
	}
	/**
	 * @return the userName
	 */
	public final String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public final void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userEmail
	 */
	public final String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public final void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userCode == null) ? 0 : userCode.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (userCode == null) {
			if (other.userCode != null)
				return false;
		} else if (!userCode.equals(other.userCode))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	
}
