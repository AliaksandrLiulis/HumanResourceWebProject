package by.htp.project.human_resource.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Class User with fields
 * <b>userId</b>,<b>name</b>,<b>surName</b>,<b>nickName</b>,<b>email</b>,<b>role</b>,<b>avaliable</b>.
 * <b>profileId</b>,<b>resumeId</b>,<b>responcedVacancyId</b>.
 */

public class User implements Serializable {

	private static final long serialVersionUID = 5242719719164225740L;

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

	User() {
	}

	/**
	 * method gets value field {@link User#userId}. User#userIdHr#idHr}.
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * method sets value in field {@link User#userId}.
	 * 
	 * @param
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * method gets value field {@link User#name}.
	 * 
	 * @return {@link User#name}.
	 */
	public String getName() {
		return name;
	}

	/**
	 * method sets value in field {@link User#name}.
	 * 
	 * @param
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * method gets value field {@link User#surName}.
	 * 
	 * @return {@link User#surName}.
	 */

	public String getSurName() {
		return surName;
	}

	/**
	 * method sets value in field {@link User#surname}.
	 * 
	 * @param
	 */
	public void setSurname(final String surname) {
		this.surName = surname;
	}

	/**
	 * method gets value field {@link User#nickName}.
	 * 
	 * @return {@link User#nickName}.
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * method sets value in field {@link User#nickName}.
	 * 
	 * @param
	 */
	public void setNickName(final String nickName) {
		this.nickName = nickName;
	}

	/**
	 * method gets value field {@link User#email}.
	 * 
	 * @return {@link User#email}.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * method sets value in field {@link User#email}.
	 * 
	 * @param
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * method gets value field {@link User#role}.
	 * 
	 * @return {@link User#role}.
	 */
	public String getRole() {
		return role;
	}

	/**
	 * method sets value in field {@link User#role}.
	 * 
	 * @param
	 */
	public void setRole(final String role) {
		this.role = role;
	}

	/**
	 * method gets value field {@link User#avaliable}.
	 * 
	 * @return {@link User#avaliable}.
	 */
	public int getAvaliable() {
		return avaliable;
	}

	/**
	 * method sets value in field {@link User#avaliable}.
	 * 
	 * @param
	 */
	public void setAvaliable(final int avaliable) {
		this.avaliable = avaliable;
	}

	/**
	 * method gets value field {@link User#profileId}.
	 * 
	 * @return {@link User#profileId}.
	 */
	public int getProfileId() {
		return profileId;
	}

	/**
	 * method sets value in field {@link User#profileId}.
	 * 
	 * @param
	 */
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	/**
	 * method gets value field {@link User#resumeId}.
	 * 
	 * @return {@link User#resumeId}.
	 */
	public int getResumeId() {
		return resumeId;
	}

	/**
	 * method sets value in field {@link User#resumeId}.
	 * 
	 * @param
	 */
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	/**
	 * method gets value field {@link User#getResponcedVacancyId}.
	 * 
	 * @return {@link User#getResponcedVacancyId}.
	 */
	public List<Integer> getResponcedVacancyId() {
		return responcedVacancyId;
	}

	/**
	 * method sets value in field {@link User#responcedVacancyId}.
	 * 
	 * @param
	 */
	public void setResponcedVacancyId(List<Integer> responcedVacancyId) {
		this.responcedVacancyId = responcedVacancyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + avaliable;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + profileId;
		result = prime * result + ((responcedVacancyId == null) ? 0 : responcedVacancyId.hashCode());
		result = prime * result + resumeId;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (avaliable != other.avaliable)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (profileId != other.profileId)
			return false;
		if (responcedVacancyId == null) {
			if (other.responcedVacancyId != null)
				return false;
		} else if (!responcedVacancyId.equals(other.responcedVacancyId))
			return false;
		if (resumeId != other.resumeId)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
}
