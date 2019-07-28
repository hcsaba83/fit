package com.myfitpage.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="foods")
public class Food {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private Integer meal1;
	private Integer meal2;
	private Integer meal3;
	private Integer meal4;
	private Integer meal5;
	private Integer water;
	private Integer extrasnack;
	private Integer alcohol;
	@ManyToOne
	private User user;
	
	public Food() {
		super();
	}

	public Food(Long id, Date date, Integer meal1, Integer meal2, Integer meal3, Integer meal4, Integer meal5, Integer water,
			Integer extrasnack, Integer alcohol, User user) {
		super();
		this.id = id;
		this.date = date;
		this.meal1 = meal1;
		this.meal2 = meal2;
		this.meal3 = meal3;
		this.meal4 = meal4;
		this.meal5 = meal5;
		this.water = water;
		this.extrasnack = extrasnack;
		this.alcohol = alcohol;
		this.user = user;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date String) {
		this.date = date;
	}

	public Integer getMeal(Integer x) {
		if(x == 1) 
			return meal1;
		if(x == 2) 
			return meal2;
		if(x == 3) 
			return meal3;
		if(x == 4) 
			return meal4;
		if(x == 5) 
			return meal5;
		if(x == 7) 
			return water;
		if(x == 6) 
			return extrasnack;
		if(x == 8)
			return alcohol;
		else return 0;

	}
	
	public void setMeal(Integer meal, Integer x) {
		if(x == 1) 
			this.meal1 = meal;
		if(x == 2) 
			this.meal2 = meal;
		if(x == 3) 
			this.meal3 = meal;
		if(x == 4) 
			this.meal4 = meal;
		if(x == 5) 
			this.meal5 = meal;
		if(x == 7) 
			this.water = meal;
		if(x == 6) 
			this.extrasnack = meal;
		if(x == 8)
			this.alcohol = meal;
	}
	
	public Integer getMeal1() {
		return meal1;
	}
	public void setMeal1(Integer meal1) {
		this.meal1 = meal1;
	}

	public Integer getMeal2() {
		return meal2;
	}
	public void setMeal2(Integer meal2) {
		this.meal2 = meal2;
	}

	public Integer getMeal3() {
		return meal3;
	}
	public void setMeal3(Integer meal3) {
		this.meal3 = meal3;
	}

	public Integer getMeal4() {
		return meal4;
	}
	public void setMeal4(Integer meal4) {
		this.meal4 = meal4;
	}

	public Integer getMeal5() {
		return meal5;
	}
	public void setMeal5(Integer meal5) {
		this.meal5 = meal5;
	}

	public Integer getWater() {
		return water;
	}
	public void setWater(Integer water) {
		this.water = water;
	}

	public Integer getExtrasnack() {
		return extrasnack;
	}
	public void setExtrasnack(Integer extrasnack) {
		this.extrasnack = extrasnack;
	}

	public Integer getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(Integer alcohol) {
		this.alcohol = alcohol;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
