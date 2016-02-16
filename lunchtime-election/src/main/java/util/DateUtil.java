package util;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * Felipe
 */

/**
 * @author Felipe
 *
 */
public class DateUtil {
	/**
	 * method responsable for convert dates
	 * @param localDate
	 * @return
	 */
	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
}
