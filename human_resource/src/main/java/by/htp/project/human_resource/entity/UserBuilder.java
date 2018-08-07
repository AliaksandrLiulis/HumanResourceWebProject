package by.htp.project.human_resource.entity;

import java.io.Serializable;

public class UserBuilder implements Serializable{
	
	private static final long serialVersionUID = -3983759731784176245L;
	private String name;
	private String surName;
	private String nickName;
	private String email;
	private String role;
	private int avaliable;
	
	public UserBuilder() {
	}

	public UserBuilder name(String name) {
		this.name = name;
		return this;
	}
	
	public UserBuilder surName(String surName) {
		this.surName = surName;
		return this;
	}
	
	public UserBuilder nickName(String nickName) {
		this.nickName = nickName;
		return this;
	}
	
	public UserBuilder email(String email) {
		this.email = email;
		return this;
	}
	
	public UserBuilder role(String role) {
		this.role = role;
		return this;
	}
	
	public UserBuilder avaliable(int avaliable) {
		this.avaliable = avaliable;
		return this;
	}
			
	public User build() {
		User user = new User();
		user.setName(name);
		user.setSurname(surName);
		user.setNickName(nickName);
		user.setEmail(email);
		user.setRole(role);
		user.setAvaliable(avaliable);	
		return user;
	}
}
