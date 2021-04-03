package com.sgyeme.app.model;

public class User {
	private String username;
	private String firstName;
	private String lastName;
	private String phone;
	private boolean active;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String id) {
		this.username = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String name) {
		this.firstName = name;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean disable) {
		this.active = disable;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName + ", birthDate=" + lastName + ", active=" + active + "]";
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
