/**
 *
 * Felipe
 */
package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import entity.User;
import entity.Vote;
import util.DateUtil;

/**
 * Class responsable for consulting voting list
 * 
 * @author Felipe
 */
public class VoteDAO {
	
	/**
	 * Validate if user still voted in the same day
	 * @param user
	 * @return
	 */
	public Vote validVotingTodayToUser(final User user) {
		Vote voting = null;
		try {
			Optional<Vote> optionalVoting = null;
			List<Vote> votingList = DataDAO.getVotingList();
			optionalVoting = votingList.stream().filter(v -> v.getVotingDate().equals(DateUtil.asDate(LocalDate.now())) && v.getUser().equals(user)).findAny();
			if (optionalVoting.isPresent()) {
				voting = optionalVoting.get();
			}
			
		} catch (Exception e) {
			System.out.println("error find voting for user " + user != null ? user.getUserEmail() : null + " " + e);
		}
		return voting;
	}

	/**
	 * method responsable to save a voting
	 * @param voting
	 */
	public  void saveVoting(Vote voting) {
		DataDAO.saveVoting(voting);
	}


}
