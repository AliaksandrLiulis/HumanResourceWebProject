package by.htp.project.human_resource.entity;

public class RespondVacancy {
	
	private int id;
	private int idVacancy;
	private int idResponded;
	
	public RespondVacancy() {
	}	

	public RespondVacancy(final int id, final int idVacancy, final int idResponded) {
		this.id = id;
		this.idVacancy = idVacancy;
		this.idResponded = idResponded;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdVacancy() {
		return idVacancy;
	}

	public void setIdVacancy(int idVacancy) {
		this.idVacancy = idVacancy;
	}

	public int getIdResponded() {
		return idResponded;
	}

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
