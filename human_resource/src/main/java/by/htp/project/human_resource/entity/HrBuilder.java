package by.htp.project.human_resource.entity;

public class HrBuilder {
	
	private int idHr;
	private String name;
	private String surName;
	private String nickName;
	private String email;
	private String role;
	private int avaliable;
	
	public HrBuilder() {
	}
	
	public HrBuilder userId(final int idHr) {
		this.idHr = idHr;
		return this;
	}
	
	public HrBuilder name(final String name) {
		this.name = name;
		return this;
	}
	
	public HrBuilder surName(final String surName) {
		this.surName = surName;
		return this;
	}
	
	public HrBuilder nickName(final String nickName) {
		this.nickName = nickName;
		return this;
	}
	
	public HrBuilder email(final String email) {
		this.email = email;
		return this;
	}
	
	public HrBuilder role(final String role) {
		this.role = role;
		return this;
	}
	
	public HrBuilder avaliable(final int avaliable) {
		this.avaliable = avaliable;
		return this;
	}
	
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
