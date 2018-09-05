package by.htp.project.human_resource.entity;

import java.io.Serializable;

/**
 * Class Vacancy with fields
 * <b>idvacancy</b>,<b>professionName</b>,<b>companyName</b>,<b>experience</b>,<b>salary</b>,<b>goods</b>,<b>dlCategory</b>,
 * <b>whoAddedId</b>,<b>whoRespondId</b>.
 */

public class Vacancy implements Serializable {

	private static final long serialVersionUID = 7071430179529416965L;

	/** field int idvacancy. */
	private int idvacancy;
	/** field String professionName. */
	private String professionName;
	/** field String companyName. */
	private String companyName;
	/** field String experience. */
	private String experience;
	/** field int salary. */
	private int salary;
	/** field String goods. */
	private String goods;
	/** field String dlCategory. */
	private String dlCategory;
	/** field int whoAddedId. */
	private int whoAddedId;
	/** field int whoRespondId. */
	private int whoRespondId;

	Vacancy() {
	}

	/**
	 * method gets value field {@link Vacancy#idvacancy}.
	 * 
	 * @return {@link Vacancy#idvacancy}.
	 */
	public int getIdvacancy() {
		return idvacancy;
	}

	/**
	 * method sets value in field {@link Vacancy#idvacancy}.
	 * 
	 * @param
	 */
	public void setIdvacancy(int idvacancy) {
		this.idvacancy = idvacancy;
	}

	/**
	 * method gets value field {@link Vacancy#professionName}.
	 * 
	 * @return {@link Vacancy#professionName}.
	 */
	public String getProfessionName() {
		return professionName;
	}

	/**
	 * method sets value in field {@link Vacancy#professionName}.
	 * 
	 * @param
	 */
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	/**
	 * method gets value field {@link Vacancy#companyName}.
	 * 
	 * @return {@link Vacancy#companyName}.
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * method sets value in field {@link Vacancy#companyName}.
	 * 
	 * @param
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * method gets value field {@link Vacancy#experience}.
	 * 
	 * @return {@link Vacancy#experience}.
	 */
	public String getExperience() {
		return experience;
	}

	/**
	 * method sets value in field {@link Vacancy#experience}.
	 * 
	 * @param
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}

	/**
	 * method gets value field {@link Vacancy#salary}.
	 * 
	 * @return {@link Vacancy#salary}.
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * method sets value in field {@link Vacancy#salary}.
	 * 
	 * @param
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * method gets value field {@link Vacancy#goods}.
	 * 
	 * @return {@link Vacancy#goods}.
	 */
	public String getGoods() {
		return goods;
	}

	/**
	 * method sets value in field {@link Vacancy#goods}.
	 * 
	 * @param
	 */
	public void setGoods(String goods) {
		this.goods = goods;
	}

	/**
	 * method gets value field {@link Vacancy#dlCategory}.
	 * 
	 * @return {@link Vacancy#dlCategory}.
	 */
	public String getDlCategory() {
		return dlCategory;
	}

	/**
	 * method sets value in field {@link Vacancy#dlCategory}.
	 * 
	 * @param
	 */
	public void setDlCategory(String dlCategory) {
		this.dlCategory = dlCategory;
	}

	/**
	 * method gets value field {@link Vacancy#whoAddedId}.
	 * 
	 * @return {@link Vacancy#whoAddedId}.
	 */
	public int getWhoAddedId() {
		return whoAddedId;
	}

	/**
	 * method sets value in field {@link Vacancy#whoAddedId}.
	 * 
	 * @param
	 */
	public void setWhoAddedId(int whoAddedId) {
		this.whoAddedId = whoAddedId;
	}

	/**
	 * method gets value field {@link Vacancy#whoRespondId}.
	 * 
	 * @return {@link Vacancy#whoRespondId}.
	 */
	public int getRespond() {
		return whoRespondId;
	}

	/**
	 * method sets value in field {@link Vacancy#whoRespondId}.
	 * 
	 * @param
	 */
	public void setRespond(int respond) {
		this.whoRespondId = respond;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((dlCategory == null) ? 0 : dlCategory.hashCode());
		result = prime * result + ((experience == null) ? 0 : experience.hashCode());
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
		result = prime * result + idvacancy;
		result = prime * result + ((professionName == null) ? 0 : professionName.hashCode());
		result = prime * result + whoRespondId;
		result = prime * result + salary;
		result = prime * result + whoAddedId;
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
		Vacancy other = (Vacancy) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (dlCategory == null) {
			if (other.dlCategory != null)
				return false;
		} else if (!dlCategory.equals(other.dlCategory))
			return false;
		if (experience == null) {
			if (other.experience != null)
				return false;
		} else if (!experience.equals(other.experience))
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
			return false;
		if (idvacancy != other.idvacancy)
			return false;
		if (professionName == null) {
			if (other.professionName != null)
				return false;
		} else if (!professionName.equals(other.professionName))
			return false;
		if (whoRespondId != other.whoRespondId)
			return false;
		if (salary != other.salary)
			return false;
		if (whoAddedId != other.whoAddedId)
			return false;
		return true;
	}
}
