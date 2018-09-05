package by.htp.project.human_resource.entity;

import java.util.List;

/**
 * Class UserBuilder with fields
 * <b>userId</b>,<b>name</b>,<b>surName</b>,<b>nickName</b>,<b>email</b>,<b>role</b>,<b>avaliable</b>.
 * <b>profileId</b>,<b>resumeId</b>,<b>responcedVacancyId</b>.
 */

public class UserBuilder {
	
	/** field int userId. */
	private int userId;
	/** field String name. */
	private String name;
	/** field String surName. */
	private String surName;
	/** field String nickName. */
	private String nickName;
	/** field String email. */
	private String email;
	/** field String role. */
	private String role;
	/** field int avaliable. */
	private int avaliable;
	/** field int profileId. */
	private int profileId;
	/** field int resumeId. */
	private int resumeId;
	/** field List<Integer> responcedVacancyId. */
	private List<Integer> responcedVacancyId;
	
	public UserBuilder() {
	}	
	
	/**
	 * method sets value in field {@link UserBuilder#userId}.
	 * 
	 * @return this.
	 */
	public UserBuilder userId(final int id) {
		this.userId = id;
		return this;
	}
	
	/**
	 * method sets value in field {@link UserBuilder#name}.
	 * 
	 * @return this.
	 */
	public UserBuilder name(final String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * method sets value in field {@link UserBuilder#surName}.
	 * 
	 * @return this.
	 */
	public UserBuilder surName(final String surName) {
		this.surName = surName;
		return this;
	}
	
	/**
	 * method sets value in field {@link UserBuilder#nickName}.
	 * 
	 * @return this.
	 */
	public UserBuilder nickName(final String nickName) {
		this.nickName = nickName;
		return this;
	}
	
	/**
	 * method sets value in field {@link UserBuilder#email}.
	 * 
	 * @return this.
	 */
	public UserBuilder email(final String email) {
		this.email = email;
		return this;
	}
	
	/**
	 * method sets value in field {@link UserBuilder#role}.
	 * 
	 * @return this.
	 */
	public UserBuilder role(final String role) {
		this.role = role;
		return this;
	}
	
	/**
	 * method sets value in field {@link UserBuilder#avaliable}.
	 * 
	 * @return this.
	 */
	public UserBuilder avaliable(final int avaliable) {
		this.avaliable = avaliable;
		return this;
	}
	
	/**
	 * method sets value in field {@link UserBuilder#profileId}.
	 * 
	 * @return this.
	 */
	public UserBuilder profileId(final int profileId) {
		this.profileId = profileId;
		return this;
	}
	
	/**
	 * method sets value in field {@link UserBuilder#resumeId}.
	 * 
	 * @return this.
	 */
	public UserBuilder resumeId(final int resumeId) {
		this.resumeId = resumeId;
		return this;
	}
	
	/**
	 * method sets value in field {@link UserBuilder#responcedVacancyId}.
	 * 
	 * @return this.
	 */
	public UserBuilder responcedVacancyId(final List<Integer> responcedVacancyId) {
		this.responcedVacancyId = responcedVacancyId;
		return this;
	}		
			
	/**
	 * method creates new {@link User} instance and sets value in field {@link User}.
	 * 
	 * @return {@link User} instance.
	 */
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
		user.setResponcedVacancyId(responcedVacancyId);
		return user;
	}
}
