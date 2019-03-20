package terminkalender.model.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import terminkalender.model.interfaces.User;
import terminkalender.util.Views;

import javax.persistence.*;

/**
 * this is model class for the User Object
 * the Object contains:
 *      its own id as primary key in the database
 *      various attributes describing the user
 *
 * @author Piri, Shenna RWP
 * @author Bimantara, Agra
 */
@Entity
@Table(name = "user")
@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserImpl implements User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid", nullable = false, unique = true)
	private int userId;

	@Column(name = "password")
	private String password;

	@Column(name = "name")
	@JsonView(Views.Public.class)
	private String name;

	@Column(name = "lastname")
	@JsonView(Views.Public.class)
	private String lastName;

	@Column(name = "email", unique = true)
	private String email;
}
