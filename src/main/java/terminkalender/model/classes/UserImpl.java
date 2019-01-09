package terminkalender.model.classes;

import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.User;

@Getter @Setter
public class UserImpl implements User
{
	private int userId;
	private String password;
	private String name;
	private String lastName;
	private String email;
}
