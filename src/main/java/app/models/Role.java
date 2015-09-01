package app.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue
	@Column(name="role_id")
	private long roleId;
	
	@Column(name = "name", unique = true, nullable = false, length = 40)
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users;

	//constructors
	public Role() {
		this.users = new ArrayList<User>();
	}
	
	// getters & setters
	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	
	
	
	
}
