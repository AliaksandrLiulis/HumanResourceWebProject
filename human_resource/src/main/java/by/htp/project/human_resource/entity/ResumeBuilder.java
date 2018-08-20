package by.htp.project.human_resource.entity;

public class ResumeBuilder {
	private int id;
	
	
	public ResumeBuilder() {
	}

	public ResumeBuilder id(final int id) {
		this.id = id;
		return this;
	}
	
	public Resume build() {
		Resume resume = new Resume();
		resume.setId(id);
		return resume;
	}
}
