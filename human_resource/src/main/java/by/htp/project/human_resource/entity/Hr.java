package by.htp.project.human_resource.entity;

import java.io.Serializable;

/**
 * Class Hr with fields
 * <b>idHr</b>,<b>name</b>,<b>surName</b>,<b>nickName</b>,<b>email</b>,<b>role</b>,<b>avaliable</b>.
 */

public class Hr implements Serializable {

	private static final long serialVersionUID = -2649150267518415428L;
	/** field int idHr. */
	private int idHr;
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

	Hr() {
	}

	/**
	 * method gets value field {@link Hr#idHr}.
	 * 
	 * @return {@link Hr#idHr}.
	 */
	public int getIdHr() {
		return idHr;
	}

	/**
	 * method sets value in field {@link Hr#idHr}.
	 * 
	 * @param
	 */
	public void setIdHr(int idHr) {
		this.idHr = idHr;
	}

	/**
	 * method gets value field {@link Hr#name}.
	 * 
	 * @return {@link Hr#name}.
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
	 * method gets value field {@link Hr#surName}.
	 * 
	 * @return {@link Hr#surName}.
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
	 * method gets value field {@link Hr#nickName}.
	 * 
	 * @return {@link Hr#nickName}.
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * method sets value in field {@link Hr#nickName}.
	 * 
	 * @param
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * method gets value field {@link Hr#email}.
	 * 
	 * @return {@link Hr#email}.
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
	 * method gets value field {@link Hr#role}.
	 * 
	 * @return {@link Hr#role}.
	 */
	public String getRole() {
		return role;
	}

	/**
	 * method sets value in field {@link Hr#role}.
	 * 
	 * @param
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * method gets value field {@link Hr#avaliable}.
	 * 
	 * @return {@link Hr#avaliable}.
	 */
	public int getAvaliable() {
		return avaliable;
	}

	/**
	 * method sets value in field {@link Hr#avaliable}.
	 * 
	 * @param
	 */
	public void setAvaliable(int avaliable) {
		this.avaliable = avaliable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + avaliable;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idHr;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
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
		Hr other = (Hr) obj;
		if (avaliable != other.avaliable)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idHr != other.idHr)
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
		return true;
	}

}
