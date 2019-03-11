package terminkalender.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.User;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter @Setter
public class UserImpl implements User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid", nullable = false, unique = true)
	private int userId;

	@Column(name = "password")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email", unique = true)
	private String email;
}
