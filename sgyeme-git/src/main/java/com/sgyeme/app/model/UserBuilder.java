package com.sgyeme.app.model;

public class UserBuilder implements BaseBuilder<User> {
	private User user = new User();

	public UserBuilder username(String id) {
		user.setUsername(id);
		return this;
	}

	public UserBuilder firstName(String pName) {
		user.setFirstName(pName);
		return this;
	}
	public UserBuilder lastName(String pName) {
		user.setLastName(pName);
		return this;
	}

	public UserBuilder phone(String val) {
		user.setPhone(val);
		return this;
	}

	public UserBuilder active(boolean status) {
		user.setActive(status);
		return this;
	}

	public User build() {
		return user;
	}
}
