package by.htp.project.human_resource.entity;

public class UserBuilder {
	
	private int id;
	private String name;
	private String surName;
	private String nickName;
	private String email;
	private String role;
	private int avaliable;
	private int profile;
	
	public UserBuilder() {
	}
	
	
	public UserBuilder id(final int id) {
		this.id = id;
		return this;
	}
	
	public UserBuilder name(final String name) {
		this.name = name;
		return this;
	}
	
	public UserBuilder surName(final String surName) {
		this.surName = surName;
		return this;
	}
	
	public UserBuilder nickName(final String nickName) {
		this.nickName = nickName;
		return this;
	}
	
	public UserBuilder email(final String email) {
		this.email = email;
		return this;
	}
	
	public UserBuilder role(final String role) {
		this.role = role;
		return this;
	}
	
	public UserBuilder avaliable(final int avaliable) {
		this.avaliable = avaliable;
		return this;
	}
	
	public UserBuilder profile(final int profile) {
		this.profile = profile;
		return this;
	}
			
	public User build() {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setSurname(surName);
		user.setNickName(nickName);
		user.setEmail(email);
		user.setRole(role);
		user.setAvaliable(avaliable);	
		user.setProfiles(profile);
		return user;
	}
}
