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
	public int getUserId();
	public void setUserId(int userId);

	//----------------PASSWORD----------------
	public String getPassword();
	public void setPassword(String password);

	//----------------NAME----------------
	public String getName();
	public void setName(String name);

	//----------------LASTNAME----------------
	public String getLastName();
	public void setLastName(String lastName);

	//----------------EMAIL----------------
	public String getEmail();
	public void setEmail(String email);

}
