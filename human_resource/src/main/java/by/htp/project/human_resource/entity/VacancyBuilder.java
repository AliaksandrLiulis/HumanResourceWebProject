package by.htp.project.human_resource.entity;

/**
 * Class VacancyBuilder with fields
 * <b>idvacancy</b>,<b>professionName</b>,<b>companyName</b>,<b>experience</b>,<b>salary</b>,<b>goods</b>,<b>dlCategory</b>,
 * <b>whoAddedId</b>,<b>whoRespondId</b>.
 */

public class VacancyBuilder {

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

	public VacancyBuilder() {
	}

	/**
	 * method sets value in field {@link VacancyBuilder#idvacancy}.
	 * 
	 * @return this.
	 */
	public VacancyBuilder idvacancy(final int idvacancy) {
		this.idvacancy = idvacancy;
		return this;
	}

	/**
	 * method sets value in field {@link VacancyBuilder#professionName}.
	 * 
	 * @return this.
	 */
	public VacancyBuilder professionName(final String professionName) {
		this.professionName = professionName;
		return this;
	}

	/**
	 * method sets value in field {@link VacancyBuilder#companyName}.
	 * 
	 * @return this.
	 */
	public VacancyBuilder companyName(final String companyName) {
		this.companyName = companyName;
		return this;
	}

	/**
	 * method sets value in field {@link VacancyBuilder#experience}.
	 * 
	 * @return this.
	 */
	public VacancyBuilder experience(final String experience) {
		this.experience = experience;
		return this;
	}

	/**
	 * method sets value in field {@link VacancyBuilder#salary}.
	 * 
	 * @return this.
	 */
	public VacancyBuilder salary(final int salary) {
		this.salary = salary;
		return this;
	}

	/**
	 * method sets value in field {@link VacancyBuilder#goods}.
	 * 
	 * @return this.
	 */
	public VacancyBuilder goods(final String goods) {
		this.goods = goods;
		return this;
	}

	/**
	 * method sets value in field {@link VacancyBuilder#dlCategory}.
	 * 
	 * @return this.
	 */
	public VacancyBuilder dlCategory(final String dlCategory) {
		this.dlCategory = dlCategory;
		return this;
	}

	/**
	 * method sets value in field {@link VacancyBuilder#whoAddedId}.
	 * 
	 * @return this.
	 */
	public VacancyBuilder whoAddedId(final int whoAddedId) {
		this.whoAddedId = whoAddedId;
		return this;
	}

	/**
	 * method sets value in field {@link VacancyBuilder#whoRespondId}.
	 * 
	 * @return this.
	 */
	public VacancyBuilder respond(final int respond) {
		this.whoRespondId = respond;
		return this;
	}

	/**
	 * method creates new {@link Vacancy} instance and sets value in field
	 * {@link Vacancy}.
	 * 
	 * @return {@link Vacancy} instance.
	 */
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
