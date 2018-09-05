package by.htp.project.human_resource.entity;

import java.io.Serializable;

/**
 * Class RespondVacancy with fields
 * <b>id</b>,<b>idVacancy</b>,<b>idResponded</b>.
 */

public class RespondVacancy implements Serializable {

	private static final long serialVersionUID = 7279862139498591887L;

	/** field int id. */
	private int id;
	/** field int idVacancy. */
	private int idVacancy;
	/** field int idResponded. */
	private int idResponded;

	public RespondVacancy() {
	}

	/**
	 * Constructor - creates new object RespondVacancy with field
	 * {@link RespondVacancy#id},{@link RespondVacancy#idVacancy},{@link RespondVacancy#idResponded}
	 * 
	 */
	public RespondVacancy(final int id, final int idVacancy, final int idResponded) {
		this.id = id;
		this.idVacancy = idVacancy;
		this.idResponded = idResponded;
	}

	/**
	 * method gets value field {@link RespondVacancy#getId}.
	 * 
	 * @return {@link RespondVacancy#getId}.
	 */
	public int getId() {
		return id;
	}

	/**
	 * method sets value in field {@link RespondVacancy#id}.
	 * 
	 * @param
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * method gets value field {@link RespondVacancy#idVacancy}.
	 * 
	 * @return {@link RespondVacancy#idVacancy}.
	 */
	public int getIdVacancy() {
		return idVacancy;
	}

	/**
	 * method sets value in field {@link RespondVacancy#idVacancy}.
	 * 
	 * @param
	 */
	public void setIdVacancy(int idVacancy) {
		this.idVacancy = idVacancy;
	}

	/**
	 * method gets value field {@link RespondVacancy#idResponded}.
	 * 
	 * @return {@link RespondVacancy#idResponded}.
	 */
	public int getIdResponded() {
		return idResponded;
	}

	/**
	 * method sets value in field {@link RespondVacancy#idResponded}.
	 * 
	 * @param
	 */
	public void setIdResponded(int idResponded) {
		this.idResponded = idResponded;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idResponded;
		result = prime * result + idVacancy;
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
		RespondVacancy other = (RespondVacancy) obj;
		if (id != other.id)
			return false;
		if (idResponded != other.idResponded)
			return false;
		if (idVacancy != other.idVacancy)
			return false;
		return true;
	}
}
