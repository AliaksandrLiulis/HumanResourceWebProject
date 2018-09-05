package by.htp.project.human_resource.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Class Resume with fields
 * <b>id</b>,<b>name</b>,<b>surName</b>,<b>email</b>,<b>registrationDate</b>,<b>birthDayDate</b>,<b>phone</b>,
 * <b>residence</b>,<b>workSpeciality</b>,<b>workExpirience</b>,<b>education</b>,<b>photoPath</b>,<b>aboutUser</b>,<b>idUser</b>.
 */

public class Resume implements Serializable {

	private static final long serialVersionUID = 4031613634272073009L;

	/** field int id. */
	private int id;
	/** field String name. */
	private String name;
	/** field String surName. */
	private String surName;
	/** field String email. */
	private String email;
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
	/** field int idUser. */
	private int idUser;

	Resume() {
	}

	/**
	 * method gets value field {@link Resume#id}.
	 * 
	 * @return {@link Resume#id}.
	 */
	public int getId() {
		return id;
	}

	/**
	 * method sets value in field {@link Hr#id}.
	 * 
	 * @param
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * method gets value field {@link Resume#name}.
	 * 
	 * @return {@link Resume#name}.
	 */
	public String getName() {
		return name;
	}

	/**
	 * method sets value in field {@link Hr#name}.
	 * 
	 * @param
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * method gets value field {@link Resume#surName}.
	 * 
	 * @return {@link Resume#surName}.
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * method sets value in field {@link Hr#surName}.
	 * 
	 * @param
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}

	/**
	 * method gets value field {@link Resume#email}.
	 * 
	 * @return {@link Resume#email}.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * method sets value in field {@link Hr#email}.
	 * 
	 * @param
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * method gets value field {@link Resume#registrationDate}.
	 * 
	 * @return {@link Resume#registrationDate}.
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * method sets value in field {@link Hr#registrationDate}.
	 * 
	 * @param
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * method gets value field {@link Resume#birthDayDate}.
	 * 
	 * @return {@link Resume#birthDayDate}.
	 */
	public Date getBirthDayDate() {
		return birthDayDate;
	}

	/**
	 * method sets value in field {@link Hr#birthDayDate}.
	 * 
	 * @param
	 */
	public void setBirthDayDate(Date birthDayDate) {
		this.birthDayDate = birthDayDate;
	}

	/**
	 * method gets value field {@link Resume#phone}.
	 * 
	 * @return {@link Resume#phone}.
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * method sets value in field {@link Hr#phone}.
	 * 
	 * @param
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * method gets value field {@link Resume#residence}.
	 * 
	 * @return {@link Resume#residence}.
	 */
	public String getResidence() {
		return residence;
	}

	/**
	 * method sets value in field {@link Hr#residence}.
	 * 
	 * @param
	 */
	public void setResidence(String residence) {
		this.residence = residence;
	}

	/**
	 * method gets value field {@link Resume#workSpeciality}.
	 * 
	 * @return {@link Resume#workSpeciality}.
	 */
	public String getWorkSpeciality() {
		return workSpeciality;
	}

	/**
	 * method sets value in field {@link Hr#workSpeciality}.
	 * 
	 * @param
	 */
	public void setWorkSpeciality(String workSpeciality) {
		this.workSpeciality = workSpeciality;
	}

	/**
	 * method gets value field {@link Resume#workExpirience}.
	 * 
	 * @return {@link Resume#workExpirience}.
	 */
	public String getWorkExpirience() {
		return workExpirience;
	}

	/**
	 * method sets value in field {@link Hr#workExpirience}.
	 * 
	 * @param
	 */
	public void setWorkExpirience(String workExpirience) {
		this.workExpirience = workExpirience;
	}

	/**
	 * method gets value field {@link Resume#education}.
	 * 
	 * @return {@link Resume#education}.
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * method sets value in field {@link Hr#education}.
	 * 
	 * @param
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * method gets value field {@link Resume#photoPath}.
	 * 
	 * @return {@link Resume#photoPath}.
	 */
	public String getPhotoPath() {
		return photoPath;
	}

	/**
	 * method sets value in field {@link Hr#photoPath}.
	 * 
	 * @param
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	/**
	 * method gets value field {@link Resume#aboutUser}.
	 * 
	 * @return {@link Resume#aboutUser}.
	 */
	public String getAboutUser() {
		return aboutUser;
	}

	/**
	 * method sets value in field {@link Hr#aboutUser}.
	 * 
	 * @param
	 */
	public void setAboutUser(String aboutUser) {
		this.aboutUser = aboutUser;
	}

	/**
	 * method gets value field {@link Resume#idUser}.
	 * 
	 * @return {@link Resume#idUser}.
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * method sets value in field {@link Hr#idUser}.
	 * 
	 * @param
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboutUser == null) ? 0 : aboutUser.hashCode());
		result = prime * result + ((birthDayDate == null) ? 0 : birthDayDate.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + idUser;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((photoPath == null) ? 0 : photoPath.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((residence == null) ? 0 : residence.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
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
		Resume other = (Resume) obj;
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (idUser != other.idUser)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
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
