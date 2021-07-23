package com.apurs.microservices.depsylsservice.dto;

public class DepsylDTO {
	private int id;
	private int departmentId;
	private int syllabusId;
	
	public DepsylDTO() {
		super();
	}

	public DepsylDTO(int id, int departmentId, int syllabusId) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.syllabusId = syllabusId;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	public int getSyllabusId() {
		return syllabusId;
	}
	
	public void setSyllabusId(int syllabusId) {
		this.syllabusId = syllabusId;
	}
}
