package ma.ac.ena.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
	@Id
	private String username;
	private String password;
	private boolean activated;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USERS_ROLES")
	private Collection<Role> roles;

	// getters and setters
	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public User(String username, String password, boolean activated) {
		super();
		this.username = username;
		this.password = password;
		this.activated = activated;
	}

	public User() {
		super();
	}

}
