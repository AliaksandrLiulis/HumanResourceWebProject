package by.htp.project.human_resource.entity;

import java.io.Serializable;
import java.sql.Date;

public class Profile implements Serializable{
	
	private static final long serialVersionUID = -859500360106064849L;
	
	private int id;
	private Date registrationDate;
	private Date birthDayDate;
	private String phone;
	private String residence;
	private String workSpeciality;
	private int workExpirience;
	private String education;
	private String photoPath;
	private String abouteUser;
	
	Profile() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(final Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getBirthDayDate() {
		return birthDayDate;
	}

	public void setBirthDayDate(final Date birthDayDate) {
		this.birthDayDate = birthDayDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(final String residence) {
		this.residence = residence;
	}

	public String getWorkSpeciality() {
		return workSpeciality;
	}

	public void setWorkSpeciality(final String workSpeciality) {
		this.workSpeciality = workSpeciality;
	}

	public int getWorkExpirience() {
		return workExpirience;
	}

	public void setWorkExpirience(final int workExpirience) {
		this.workExpirience = workExpirience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(final String education) {
		this.education = education;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(final String photoPath) {
		this.photoPath = photoPath;
	}

	public String getAbouteUser() {
		return abouteUser;
	}

	public void setAbouteUser(final String abouteUser) {
		this.abouteUser = abouteUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abouteUser == null) ? 0 : abouteUser.hashCode());
		result = prime * result + ((birthDayDate == null) ? 0 : birthDayDate.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + id;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((photoPath == null) ? 0 : photoPath.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((residence == null) ? 0 : residence.hashCode());
		result = prime * result + workExpirience;
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
		if (abouteUser == null) {
			if (other.abouteUser != null)
				return false;
		} else if (!abouteUser.equals(other.abouteUser))
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
		if (id != other.id)
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
		if (workExpirience != other.workExpirience)
			return false;
		if (workSpeciality == null) {
			if (other.workSpeciality != null)
				return false;
		} else if (!workSpeciality.equals(other.workSpeciality))
			return false;
		return true;
	}
	
	
	
	
	

}
