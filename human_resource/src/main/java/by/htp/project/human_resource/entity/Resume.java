package by.htp.project.human_resource.entity;

import java.io.Serializable;

public class Resume implements Serializable {
	
	private static final long serialVersionUID = 4031613634272073009L;
	private int id;

	Resume() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Resume other = (Resume) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	

}
