package terminkalender.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import terminkalender.model.interfaces.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class util
{
	public static String convertTimeToString(LocalDateTime localDateTime) {
		return localDateTime.truncatedTo(ChronoUnit.MINUTES)
							 .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	public static LocalDateTime convertStringToTime(String time) {
		return LocalDateTime.parse(time, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
							 .truncatedTo(ChronoUnit.MINUTES);
	}

	public static LocalDate convertStringToDate(String date) {
		return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
	}

	/**
	 * Helpfunction, convert List of objects to JSON string to be returned to client
	 * @param objectsList List containing all events
	 * @return JSON String
	 */
	public static String convertListToJSON(List<?> objectsList) {
		String listAsJSON = "";
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			listAsJSON = objectMapper.writeValueAsString(objectsList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return listAsJSON;
	}

	public static String convertUserListToNameList(List<User> userList) {
		String result = "";
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
		try {
			result = mapper.writerWithView(Views.Public.class)
						   .writeValueAsString(userList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;

	}


}
