package by.htp.project.human_resource.entity;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 5242719719164225740L;

	private int id;
	private String name;
	private String surName;
	private String nickName;
	private String email;
	private String role;
	private int avaliable;
	private int profile;

    User() {
	}	
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public void setProfile(int profile) {
		this.profile = profile;
	}



	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return surName;
	}

	public void setSurname(final String surname) {
		this.surName = surname;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(final String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(final String role) {
		this.role = role;
	}

	public int getAvaliable() {
		return avaliable;
	}

	public void setAvaliable(final int avaliable) {
		this.avaliable = avaliable;
	}	
	

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getProfile() {
		return profile;
	}

	public void setProfiles(int profile) {
		this.profile = profile;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + avaliable;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + profile;
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
		User other = (User) obj;
		if (avaliable != other.avaliable)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
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
		if (profile != other.profile)
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
