package com.haridass.springboot.basics.springbootin10steps.user;

import java.util.Date;

public class User {

	private Integer id;
	
	private String name;
	
	private Date brithDate;

	
	public User(Integer id, String name, Date brithDate) {
		super();
		this.id = id;
		this.name = name;
		this.brithDate = brithDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBrithDate() {
		return brithDate;
	}

	public void setBrithDate(Date brithDate) {
		this.brithDate = brithDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", brithDate=" + brithDate + "]";
	}
	
	
	
}
