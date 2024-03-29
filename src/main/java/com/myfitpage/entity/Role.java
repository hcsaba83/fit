package com.myfitpage.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.myfitpage.entity.User;

@Entity( name = "roles" )
public class Role {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	private String role;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();
	
	public Role() {
	}

	public Role(String role) {

		this.role = role;
	}

	public Role(Long id, String role, Set<User> users) {
		this.id = id;
		this.role = role;
		this.users = users;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", workers=" + users + "]";
	}

}
