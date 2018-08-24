package by.htp.project.human_resource.entity;

import java.util.Date;

public class ResumeBuilder {
	private int id;
	private String name;
	private String surName;
	private String email;
	private Date registrationDate;
	private Date birthDayDate;
	private String phone;
	private String residence;
	private String workSpeciality;
	private String workExpirience;
	private String education;
	private String photoPath;
	private String aboutUser;
	private int idUser;

	public ResumeBuilder() {
	}

	public ResumeBuilder id(final int id) {
		this.id = id;
		return this;
	}

	public ResumeBuilder name(final String name) {
		this.name = name;
		return this;
	}

	public ResumeBuilder surName(final String surName) {
		this.surName = surName;
		return this;
	}

	public ResumeBuilder email(final String email) {
		this.email = email;
		return this;
	}

	public ResumeBuilder registrationDate(final Date registrationDate) {
		this.registrationDate = registrationDate;
		return this;
	}

	public ResumeBuilder birthDayDate(final Date birthDayDate) {
		this.birthDayDate = birthDayDate;
		return this;
	}

	public ResumeBuilder phone(final String phone) {
		this.phone = phone;
		return this;
	}

	public ResumeBuilder residence(final String residence) {
		this.residence = residence;
		return this;
	}

	public ResumeBuilder workSpeciality(final String workSpeciality) {
		this.workSpeciality = workSpeciality;
		return this;
	}

	public ResumeBuilder workExpirience(final String workExpirience) {
		this.workExpirience = workExpirience;
		return this;
	}

	public ResumeBuilder education(final String education) {
		this.education = education;
		return this;
	}

	public ResumeBuilder photoPath(final String photoPath) {
		this.photoPath = photoPath;
		return this;
	}

	public ResumeBuilder aboutUser(final String aboutUser) {
		this.aboutUser = aboutUser;
		return this;
	}

	public ResumeBuilder idUser(final int idUser) {
		this.idUser = idUser;
		return this;
	}

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
