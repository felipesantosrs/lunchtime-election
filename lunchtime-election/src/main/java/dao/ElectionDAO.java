
package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import entity.Election;
import util.DateUtil;

/**
 * Class responsable for consulting election list
 * @author Felipe
 */
public class ElectionDAO {
	
	/**
	 * Responsable for verification of election into day
	 * @return
	 */
	public Election getElectionDay() {		
		Optional<Election> election = null;
		List<Election> electionList = DataDAO.getElectionList();
		election = electionList.stream().filter(e -> e.getElectionDate().equals(DateUtil.asDate(LocalDate.now()))).findFirst();
		if (election.isPresent()) {
			return election.get();
		}else{
			return null;
		}

	}
	
	public List<Election> lastWeekElection(){
		List<Election> electionList = DataDAO.getElectionList();
		return electionList.stream().filter(e -> e.getElectionDate().after(DateUtil.asDate((LocalDate.now().minusDays(7))))).collect(Collectors.toList());
	}

	public static void saveElection(Election election){
		DataDAO.saveElection(election);
	}
	

	

}
