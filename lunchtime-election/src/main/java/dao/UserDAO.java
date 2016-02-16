/**
 *
 * Felipe
 */
package dao;

import java.util.List;
import java.util.Optional;

import entity.User;

/**
 * Class responsable for consulting users list
 * 
 * @author Felipe
 */
public class UserDAO {

	/**
	 * Responsable for showing list of users
	 * 
	 * @return
	 */
	public List<User> userList() {
		return DataDAO.getUserList();

	}

	/**
	 * This method find the user for e-mail
	 * 
	 * @return
	 */
	public User getUser(String email) {
		Optional<User> optionalUser = null;
		User user = null;
		try {
			optionalUser = userList().stream().filter(u -> u.getUserEmail().equals(email)).findFirst();
			if (optionalUser.isPresent()) {
				user = optionalUser.get();
			}
		} catch (Exception e) {
			System.out.println("error find user : " + email + " " + e);
			
		}
		return user;
	}
}
