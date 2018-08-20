package by.htp.project.human_resource.entity;

import java.io.Serializable;

public class Vacancy implements Serializable{
	
	
	private static final long serialVersionUID = 7071430179529416965L;
	
	private int idvacancy;
	private String professionName;
	private String companyName;
	private String experience;
	private int salary;
	private String goods;
	private String dlCategory;
	private int whoAddedId;
	
		
	Vacancy() {
		
	}
	public int getIdvacancy() {
		return idvacancy;
	}
	public void setIdvacancy(int idvacancy) {
		this.idvacancy = idvacancy;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getDlCategory() {
		return dlCategory;
	}
	public void setDlCategory(String dlCategory) {
		this.dlCategory = dlCategory;
	}
	
	public int getWhodded() {
		return whoAddedId;
	}
	public void setWhodded(int whodded) {
		this.whoAddedId = whodded;
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
		if (salary != other.salary)
			return false;
		if (whoAddedId != other.whoAddedId)
			return false;
		return true;
	}
	
	
	
}
