package by.htp.project.human_resource.entity;

import java.util.List;

public class UserBuilder {
	
	private int userId;
	private String name;
	private String surName;
	private String nickName;
	private String email;
	private String role;
	private int avaliable;
	private int profileId;
	private int resumeId;
	private List<Integer> respondedVacancyId;
	
	public UserBuilder() {
	}	
	
	public UserBuilder userId(final int id) {
		this.userId = id;
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
	
	public UserBuilder profileId(final int profileId) {
		this.profileId = profileId;
		return this;
	}
	
	public UserBuilder resumeId(final int resumeId) {
		this.resumeId = resumeId;
		return this;
	}
	
	public UserBuilder responcedVacancyId(final List<Integer> responcedVacancyId) {
		this.respondedVacancyId = responcedVacancyId;
		return this;
	}		
			
	public User build() {
		User user = new User();
		user.setUserId(userId);
		user.setName(name);
		user.setSurname(surName);
		user.setNickName(nickName);
		user.setEmail(email);
		user.setRole(role);
		user.setAvaliable(avaliable);	
		user.setProfileId(profileId);
		user.setResumeId(resumeId);
		user.setResponcedVacancyId(respondedVacancyId);
		return user;
	}
}
