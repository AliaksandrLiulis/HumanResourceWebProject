package by.htp.project.human_resource.entity;

/**
 * Class builds a new instance Hr with fields
 * <b>idHr</b>,<b>name</b>,<b>surName</b>,<b>nickName</b>,<b>email</b>,<b>role</b>,<b>avaliable</b>.
 */

public class HrBuilder {

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

	public HrBuilder() {
	}

	/**
	 * method sets value in field {@link HrBuilder#idHr}.
	 * 
	 * @return this.
	 */
	public HrBuilder userId(final int idHr) {
		this.idHr = idHr;
		return this;
	}

	/**
	 * method sets value in field {@link HrBuilder#name}.
	 * 
	 * @return this.
	 */
	public HrBuilder name(final String name) {
		this.name = name;
		return this;
	}

	/**
	 * method sets value in field {@link HrBuilder#surName}.
	 * 
	 * @return this.
	 */
	public HrBuilder surName(final String surName) {
		this.surName = surName;
		return this;
	}

	/**
	 * method sets value in field {@link HrBuilder#nickName}.
	 * 
	 * @return this.
	 */
	public HrBuilder nickName(final String nickName) {
		this.nickName = nickName;
		return this;
	}

	/**
	 * method sets value in field {@link HrBuilder#email}.
	 * 
	 * @return this.
	 */
	public HrBuilder email(final String email) {
		this.email = email;
		return this;
	}

	/**
	 * method sets value in field {@link HrBuilder#role}.
	 * 
	 * @return this.
	 */
	public HrBuilder role(final String role) {
		this.role = role;
		return this;
	}

	/**
	 * method sets value in field {@link HrBuilder#avaliable}.
	 * 
	 * @return this.
	 */
	public HrBuilder avaliable(final int avaliable) {
		this.avaliable = avaliable;
		return this;
	}

	/**
	 * method creates new {@link Hr} instance and sets value in field {@link Hr}.
	 * 
	 * @return {@link Hr} instance.
	 */
	public Hr build() {
		Hr hr = new Hr();
		hr.setIdHr(idHr);
		hr.setName(name);
		hr.setSurName(surName);
		hr.setNickName(nickName);
		hr.setEmail(email);
		hr.setRole(role);
		hr.setAvaliable(avaliable);
		return hr;
	}
}
