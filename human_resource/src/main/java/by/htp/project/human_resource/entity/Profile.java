package by.htp.project.human_resource.entity;

import java.io.Serializable;
import java.sql.Date;

public class Profile implements Serializable{
	
	private static final long serialVersionUID = -859500360106064849L;
	
	private int profileId;
	private Date registrationDate;
	private Date birthDayDate;
	private String phone;
	private String residence;
	private String workSpeciality;
	private String workExpirience;
	private String education;
	private String photoPath;
	private String aboutUser;
	
	Profile() {		
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getBirthDayDate() {
		return birthDayDate;
	}

	public void setBirthDayDate(Date birthDayDate) {
		this.birthDayDate = birthDayDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getWorkSpeciality() {
		return workSpeciality;
	}

	public void setWorkSpeciality(String workSpeciality) {
		this.workSpeciality = workSpeciality;
	}

	public String getWorkExpirience() {
		return workExpirience;
	}

	public void setWorkExpirience(String workExpirience) {
		this.workExpirience = workExpirience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	
	public String getAboutUser() {
		return aboutUser;
	}

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
