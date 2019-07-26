package com.myfitpage.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	private String username;
	private String fullname;
	private Integer age;
	private Integer height;
	private Integer weight;
	private String gender;
	@OneToMany(mappedBy = "user")
	private List<Activity> activites;
	@OneToMany(mappedBy = "user")
	private List<Food> foods;
	
	public User() {
		super();
	}
	

	public User(String username, String fullname, Integer age, Integer height, Integer weight, String gender,
			List<Activity> activites, List<Food> foods) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.activites = activites;
		this.foods = foods;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
