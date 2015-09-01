package app.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private long userId;
	
	@Column(name = "uername", unique = true, nullable = false, length = 200)
	private String username;
	
	@Column(name = "password", nullable = false, length = 200)
	private String password;
	
	@Column(name = "email", unique = true, nullable = false, length = 200)
	private String email;
	
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	@ManyToMany
	@JoinTable(name = "user_roles",
			joinColumns={@JoinColumn(name = "user_id", referencedColumnName="user_id")},
			inverseJoinColumns={@JoinColumn(name = "role_id", referencedColumnName="role_id")})
	private List<Role> roles;

	// contructors
	public User() {
		this.roles = new ArrayList<Role>();
	}

	// getters & setters
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
}
