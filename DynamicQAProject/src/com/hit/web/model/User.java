package com.hit.web.model;

import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport {
	private String name;
	private String password;
	private String email;
	private int id;
	private String friends;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFriends() {
		return friends;
	}

	public void setFriends(String friends) {
		this.friends = friends;
	}
}
