package com.myfitpage.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.myfitpage.entity.Role;

@Entity
@Table(name="users")
public class User {
	
	@Id
	private String username;
	private String password;
	private String fullname;
	private Integer age;
	private Integer height;
	private Integer weight;
	private String gender;
	@OneToMany(mappedBy = "user")
	private List<Activity> activites;
	@OneToMany(mappedBy = "user")
	private List<Food> foods;
	@ManyToMany (cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable (
			name = "users_roles",
			joinColumns = {@JoinColumn(name="user_id")},
			inverseJoinColumns = {@JoinColumn(name="role_id")}
			)
	private Set<Role> roles = new HashSet<Role>();
	
	public User() {
		super();
	}
	

	public User(String username, String password, String fullname, Integer age, Integer height, Integer weight, String gender,
			List<Activity> activites, List<Food> foods,  Set<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.activites = activites;
		this.foods = foods;
		this.roles = roles;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void addRoles(String roleName) {
		if (this.roles == null || this.roles.isEmpty())
			this.roles = new HashSet<>();
		this.roles.add(new Role(roleName));
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getWeight() {
		return weight;
	}
	
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public List<Activity> getActivites() {
		return activites;
	}

	public void setActivites(List<Activity> activites) {
		this.activites = activites;
	}
	
	
	
}
