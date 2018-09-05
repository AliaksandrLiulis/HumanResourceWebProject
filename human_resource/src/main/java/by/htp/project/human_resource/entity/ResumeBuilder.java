package by.htp.project.human_resource.entity;

import java.util.Date;

/**
 * Class builds a new instance Hr with fields
 * <b>id</b>,<b>name</b>,<b>surName</b>,<b>email</b>,<b>registrationDate</b>,<b>birthDayDate</b>,<b>phone</b>,
 * <b>residence</b>,<b>workSpeciality</b>,<b>workExpirience</b>,<b>education</b>,<b>photoPath</b>,<b>aboutUser</b>,<b>idUser</b>.
 */

public class ResumeBuilder {

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

	public ResumeBuilder() {
	}

	/**
	 * method sets value in field {@link ResumeBuilder#id}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder id(final int id) {
		this.id = id;
		return this;
	}

	/**
	 * method sets value in field {@link ResumeBuilder#name}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder name(final String name) {
		this.name = name;
		return this;
	}

	/**
	 * method sets value in field {@link ResumeBuilder#surName}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder surName(final String surName) {
		this.surName = surName;
		return this;
	}

	/**
	 * method sets value in field {@link ResumeBuilder#email}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder email(final String email) {
		this.email = email;
		return this;
	}

	/**
	 * method sets value in field {@link ResumeBuilder#registrationDate}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder registrationDate(final Date registrationDate) {
		this.registrationDate = registrationDate;
		return this;
	}

	/**
	 * method sets value in field {@link ResumeBuilder#birthDayDate}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder birthDayDate(final Date birthDayDate) {
		this.birthDayDate = birthDayDate;
		return this;
	}

	/**
	 * method sets value in field {@link ResumeBuilder#phone}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder phone(final String phone) {
		this.phone = phone;
		return this;
	}

	/**
	 * method sets value in field {@link ResumeBuilder#residence}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder residence(final String residence) {
		this.residence = residence;
		return this;
	}

	/**
	 * method sets value in field {@link ResumeBuilder#workSpeciality}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder workSpeciality(final String workSpeciality) {
		this.workSpeciality = workSpeciality;
		return this;
	}

	/**
	 * method sets value in field {@link ResumeBuilder#workExpirience}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder workExpirience(final String workExpirience) {
		this.workExpirience = workExpirience;
		return this;
	}

	/**
	 * method sets value in field {@link ResumeBuilder#id}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder education(final String education) {
		this.education = education;
		return this;
	}

	/**
	 * method sets value in field {@link ResumeBuilder#photoPath}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder photoPath(final String photoPath) {
		this.photoPath = photoPath;
		return this;
	}

	/**
	 * method sets value in field {@link ResumeBuilder#aboutUser}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder aboutUser(final String aboutUser) {
		this.aboutUser = aboutUser;
		return this;
	}

	/**
	 * method sets value in field {@link ResumeBuilder#idUser}.
	 * 
	 * @return this.
	 */
	public ResumeBuilder idUser(final int idUser) {
		this.idUser = idUser;
		return this;
	}

	/**
	 * method creates new {@link ResumeBuilder} instance and sets value in field {@link ResumeBuilder}.
	 * 
	 * @return {@link ResumeBuilder} instance.
	 */
	public Resume build() {
		Resume resume = new Resume();
		resume.setId(id);
		resume.setName(name);
		resume.setSurName(surName);
		resume.setEmail(email);
		resume.setRegistrationDate(registrationDate);
		resume.setBirthDayDate(birthDayDate);
		resume.setPhone(phone);
		resume.setResidence(residence);
		resume.setWorkSpeciality(workSpeciality);
		resume.setWorkExpirience(workExpirience);
		resume.setEducation(education);
		resume.setPhotoPath(photoPath);
		resume.setAboutUser(aboutUser);
		resume.setIdUser(idUser);
		return resume;
	}
}
