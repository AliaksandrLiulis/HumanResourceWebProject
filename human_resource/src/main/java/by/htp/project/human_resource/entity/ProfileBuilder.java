package by.htp.project.human_resource.entity;

import java.sql.Date;

/**
 * Class builds a new instance Profile with fields
 * <b>profileId</b>,<b>registrationDate</b>,<b>birthDayDate</b>,<b>phone</b>,<b>residence</b>,<b>workSpeciality</b>,<b>workExpirience</b>,
 * <b>education</b>,<b>photoPath</b>,<b>aboutUser</b>.
 */

public class ProfileBuilder {

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

	public ProfileBuilder() {

	}

	/**
	 * method sets value in field {@link ProfileBuilder#profileId}.
	 * 
	 * @return this.
	 */
	public ProfileBuilder profileId(final int profileId) {
		this.profileId = profileId;
		return this;
	}

	/**
	 * method sets value in field {@link ProfileBuilder#registrationDate}.
	 * 
	 * @return this.
	 */
	public ProfileBuilder registrationDate(final Date registrationDate) {
		this.registrationDate = registrationDate;
		return this;
	}

	/**
	 * method sets value in field {@link ProfileBuilder#birthDayDate}.
	 * 
	 * @return this.
	 */
	public ProfileBuilder birthDayDate(final Date birthDayDate) {
		this.birthDayDate = birthDayDate;
		return this;
	}

	/**
	 * method sets value in field {@link ProfileBuilder#phone}.
	 * 
	 * @return this.
	 */
	public ProfileBuilder phone(final String phone) {
		this.phone = phone;
		return this;
	}

	/**
	 * method sets value in field {@link ProfileBuilder#residence}.
	 * 
	 * @return this.
	 */
	public ProfileBuilder residence(final String residence) {
		this.residence = residence;
		return this;
	}

	/**
	 * method sets value in field {@link ProfileBuilder#workSpeciality}.
	 * 
	 * @return this.
	 */
	public ProfileBuilder workSpeciality(final String workSpeciality) {
		this.workSpeciality = workSpeciality;
		return this;
	}

	/**
	 * method sets value in field {@link ProfileBuilder#education}.
	 * 
	 * @return this.
	 */
	public ProfileBuilder education(final String education) {
		this.education = education;
		return this;
	}

	/**
	 * method sets value in field {@link ProfileBuilder#photoPath}.
	 * 
	 * @return this.
	 */
	public ProfileBuilder photoPath(final String photoPath) {
		this.photoPath = photoPath;
		return this;
	}

	/**
	 * method sets value in field {@link ProfileBuilder#aboutUser}.
	 * 
	 * @return this.
	 */
	public ProfileBuilder aboutUser(final String aboutUser) {
		this.aboutUser = aboutUser;
		return this;
	}

	/**
	 * method sets value in field {@link ProfileBuilder#workExpirience}.
	 * 
	 * @return this.
	 */
	public ProfileBuilder workExpirience(final String workExpirience) {
		this.workExpirience = workExpirience;
		return this;
	}

	/**
	 * method creates new {@link Profile} instance and sets value in field {@link Profile}.
	 * 
	 * @return {@link Profile} instance.
	 */
	public Profile build() {
		Profile profile = new Profile();
		profile.setProfileId(profileId);
		profile.setRegistrationDate(registrationDate);
		profile.setBirthDayDate(birthDayDate);
		profile.setPhone(phone);
		profile.setResidence(residence);
		profile.setWorkSpeciality(workSpeciality);
		profile.setWorkExpirience(workExpirience);
		profile.setEducation(education);
		profile.setPhotoPath(photoPath);
		profile.setAboutUser(aboutUser);
		return profile;
	}
}
