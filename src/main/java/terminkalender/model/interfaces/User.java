package terminkalender.model.interfaces;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import terminkalender.model.classes.UserImpl;

/**
 * Interface for model class User
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
@JsonDeserialize(as = UserImpl.class)
public interface User
{
	//----------------USERID----------------
	int getUserId();
	void setUserId(int userId);

	//----------------PASSWORD----------------
	String getPassword();
	void setPassword(String password);

	//----------------NAME----------------
	String getName();
	void setName(String name);

	//----------------LASTNAME----------------
	String getLastName();
	void setLastName(String lastName);

	//----------------EMAIL----------------
	String getEmail();
	void setEmail(String email);
}
