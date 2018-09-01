package by.htp.project.human_resource.entity;

public class VacancyBuilder {

	private int idvacancy;
	private String professionName;
	private String companyName;
	private String experience;
	private int salary;
	private String goods;
	private String dlCategory;
	private int whoAddedId;
	private int whoRespondId;

	public VacancyBuilder() {
	}

	public VacancyBuilder idvacancy(final int idvacancy) {
		this.idvacancy = idvacancy;
		return this;
	}

	public VacancyBuilder professionName(final String professionName) {
		this.professionName = professionName;
		return this;
	}

	public VacancyBuilder companyName(final String companyName) {
		this.companyName = companyName;
		return this;
	}

	public VacancyBuilder experience(final String experience) {
		this.experience = experience;
		return this;
	}

	public VacancyBuilder salary(final int salary) {
		this.salary = salary;
		return this;
	}

	public VacancyBuilder goods(final String goods) {
		this.goods = goods;
		return this;
	}

	public VacancyBuilder dlCategory(final String dlCategory) {
		this.dlCategory = dlCategory;
		return this;
	}

	public VacancyBuilder whoAddedId(final int whoAddedId) {
		this.whoAddedId = whoAddedId;
		return this;
	}

	public VacancyBuilder respond(final int respond) {
		this.whoRespondId = respond;
		return this;
	}

	public Vacancy build() {
		Vacancy vacancy = new Vacancy();
		vacancy.setIdvacancy(idvacancy);
		vacancy.setProfessionName(professionName);
		vacancy.setCompanyName(companyName);
		vacancy.setExperience(experience);
		vacancy.setSalary(salary);
		vacancy.setGoods(goods);
		vacancy.setDlCategory(dlCategory);
		vacancy.setWhoAddedId(whoAddedId);
		vacancy.setRespond(whoRespondId);
		return vacancy;
	}
}
