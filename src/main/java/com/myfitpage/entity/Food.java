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
	private Short meal1;
	private Short meal2;
	private Short meal3;
	private Short meal4;
	private Short meal5;
	private Short water;
	private Short extrasnack;
	private Short alcohol;
	@ManyToOne
	private User user;
	
	public Food() {
		super();
	}

	public Food(Long id, Date date, Short meal1, Short meal2, Short meal3, Short meal4, Short meal5, Short water,
			Short extrasnack, Short alcohol, User user) {
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

	public Short getMeal1() {
		return meal1;
	}
	public void setMeal1(Short meal1) {
		this.meal1 = meal1;
	}

	public Short getMeal2() {
		return meal2;
	}
	public void setMeal2(Short meal2) {
		this.meal2 = meal2;
	}

	public Short getMeal3() {
		return meal3;
	}
	public void setMeal3(Short meal3) {
		this.meal3 = meal3;
	}

	public Short getMeal4() {
		return meal4;
	}
	public void setMeal4(Short meal4) {
		this.meal4 = meal4;
	}

	public Short getMeal5() {
		return meal5;
	}
	public void setMeal5(Short meal5) {
		this.meal5 = meal5;
	}

	public Short getWater() {
		return water;
	}
	public void setWater(Short water) {
		this.water = water;
	}

	public Short getExtrasnack() {
		return extrasnack;
	}
	public void setExtrasnack(Short extrasnack) {
		this.extrasnack = extrasnack;
	}

	public Short getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(Short alcohol) {
		this.alcohol = alcohol;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
