package by.htp.project.human_resource.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * Class Profile with fields
 * <b>profileId</b>,<b>registrationDate</b>,<b>birthDayDate</b>,<b>phone</b>,<b>residence</b>,<b>workSpeciality</b>,<b>workExpirience</b>,
 * <b>education</b>,<b>photoPath</b>,<b>aboutUser</b>.
 */

public class Profile implements Serializable {

	private static final long serialVersionUID = -859500360106064849L;

	/** field int profileId. */
	private int profileId;
	/** field Date registrationDate. */
	private Date registrationDate;
	/** field Date birthDayDate. */
	private Date birthDayDate;
	/** field String phone. */
	private String phone;
	/** field String residence. */
	private String residence;
	/** field String workSpeciality. */
	private String workSpeciality;
	/** field String workExpirience. */
	private String workExpirience;
	/** field String education. */
	private String education;
	/** field String photoPath. */
	private String photoPath;
	/** field String aboutUser. */
	private String aboutUser;

	Profile() {
	}

	/**
	 * method gets value field {@link Profile#profileId}.
	 * 
	 * @return {@link Profile#profileId}.
	 */
	public int getProfileId() {
		return profileId;
	}

	/**
	 * method sets value in field {@link Profile#profileId}.
	 * 
	 * @param
	 */
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	/**
	 * method gets value field {@link Profile#registrationDate}.
	 * 
	 * @return {@link Profile#registrationDate}.
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * method sets value in field {@link Profile#registrationDate}.
	 * 
	 * @param
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * method gets value field {@link Profile#birthDayDate}.
	 * 
	 * @return {@link Profile#birthDayDate}.
	 */
	public Date getBirthDayDate() {
		return birthDayDate;
	}

	/**
	 * method sets value in field {@link Profile#birthDayDate}.
	 * 
	 * @param
	 */
	public void setBirthDayDate(Date birthDayDate) {
		this.birthDayDate = birthDayDate;
	}

	/**
	 * method gets value field {@link Profile#phone}.
	 * 
	 * @return {@link Profile#phone}.
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * method sets value in field {@link Profile#phone}.
	 * 
	 * @param
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * method gets value field {@link Profile#residence}.
	 * 
	 * @return {@link Profile#residence}.
	 */
	public String getResidence() {
		return residence;
	}

	/**
	 * method sets value in field {@link Profile#residence}.
	 * 
	 * @param
	 */
	public void setResidence(String residence) {
		this.residence = residence;
	}

	/**
	 * method gets value field {@link Profile#workSpeciality}.
	 * 
	 * @return {@link Profile#workSpeciality}.
	 */
	public String getWorkSpeciality() {
		return workSpeciality;
	}

	/**
	 * method sets value in field {@link Profile#workSpeciality}.
	 * 
	 * @param
	 */
	public void setWorkSpeciality(String workSpeciality) {
		this.workSpeciality = workSpeciality;
	}

	/**
	 * method gets value field {@link Profile#workExpirience}.
	 * 
	 * @return {@link Profile#workExpirience}.
	 */
	public String getWorkExpirience() {
		return workExpirience;
	}

	/**
	 * method sets value in field {@link Profile#workExpirience}.
	 * 
	 * @param
	 */
	public void setWorkExpirience(String workExpirience) {
		this.workExpirience = workExpirience;
	}

	/**
	 * method gets value field {@link Profile#education}.
	 * 
	 * @return {@link Profile#education}.
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * method sets value in field {@link Profile#education}.
	 * 
	 * @param
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * method gets value field {@link Profile#photoPath}.
	 * 
	 * @return {@link Profile#photoPath}.
	 */
	public String getPhotoPath() {
		return photoPath;
	}

	/**
	 * method sets value in field {@link Profile#photoPath}.
	 * 
	 * @param
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	/**
	 * method gets value field {@link Profile#aboutUser}.
	 * 
	 * @return {@link Profile#aboutUser}.
	 */
	public String getAboutUser() {
		return aboutUser;
	}

	/**
	 * method sets value in field {@link Profile#aboutUser}.
	 * 
	 * @param
	 */
	public void setAboutUser(String aboutUser) {
		this.aboutUser = aboutUser;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboutUser == null) ? 0 : aboutUser.hashCode());
		result = prime * result + ((birthDayDate == null) ? 0 : birthDayDate.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((photoPath == null) ? 0 : photoPath.hashCode());
		result = prime * result + profileId;
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((residence == null) ? 0 : residence.hashCode());
		result = prime * result + ((workExpirience == null) ? 0 : workExpirience.hashCode());
		result = prime * result + ((workSpeciality == null) ? 0 : workSpeciality.hashCode());
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
		Profile other = (Profile) obj;
		if (aboutUser == null) {
			if (other.aboutUser != null)
				return false;
		} else if (!aboutUser.equals(other.aboutUser))
			return false;
		if (birthDayDate == null) {
			if (other.birthDayDate != null)
				return false;
		} else if (!birthDayDate.equals(other.birthDayDate))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (photoPath == null) {
			if (other.photoPath != null)
				return false;
		} else if (!photoPath.equals(other.photoPath))
			return false;
		if (profileId != other.profileId)
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (residence == null) {
			if (other.residence != null)
				return false;
		} else if (!residence.equals(other.residence))
			return false;
		if (workExpirience == null) {
			if (other.workExpirience != null)
				return false;
		} else if (!workExpirience.equals(other.workExpirience))
			return false;
		if (workSpeciality == null) {
			if (other.workSpeciality != null)
				return false;
		} else if (!workSpeciality.equals(other.workSpeciality))
			return false;
		return true;
	}
}
