package by.htp.project.human_resource.entity;

import java.sql.Date;

public class ProfileBuilder {
	
	private int id;
	private Date registrationDate;
	private Date birthDayDate;
	private String phone;
	private String residence;
	private String workSpeciality;
	private String workExpirience;
	private String education;
	private String photoPath;
	private String abouteUser;
	
	public ProfileBuilder() {
		
	}

	public ProfileBuilder id(final int id) {
		this.id = id;
		return this;
	}
	
	public ProfileBuilder registrationDate(final Date registrationDate) {
		this.registrationDate = registrationDate;
		return this;
	}
	
	public ProfileBuilder birthDayDate(final Date birthDayDate) {
		this.birthDayDate = birthDayDate;
		return this;
	}
	
	public ProfileBuilder phone(final String phone) {
		this.phone = phone;
		return this;
	}
	
	public ProfileBuilder residence(final String residence) {
		this.residence = residence;
		return this;
	}
	
	public ProfileBuilder workSpeciality(final String workSpeciality) {
		this.workSpeciality = workSpeciality;
		return this;
	}
	
	public ProfileBuilder education(final String education) {
		this.education = education;
		return this;
	}
	
	public ProfileBuilder photoPath(final String photoPath) {
		this.photoPath = photoPath;
		return this;
	}
	
	public ProfileBuilder abouteUser(final String abouteUser) {
		this.abouteUser = abouteUser;
		return this;
	}
	
	public ProfileBuilder workExpirience(final String workExpirience) {
		this.workExpirience = workExpirience;
		return this;
	}
	
	
	
			
	public Profile build() {
		
		Profile profile = new Profile();
		profile.setId(id);
		profile.setRegistrationDate(registrationDate);
		profile.setBirthDayDate(birthDayDate);
		profile.setPhone(phone);
		profile.setResidence(residence);	
		profile.setWorkSpeciality(workSpeciality);	
		profile.setWorkExpirience(workExpirience);	
		profile.setEducation(education);
		profile.setPhotoPath(photoPath);
		profile.setAbouteUser(abouteUser);
			
		return profile;
	}

}
