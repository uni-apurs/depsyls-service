package com.apurs.microservices.depsylsservice.dto;

import java.time.ZonedDateTime;

public class DepsylUpdateDTO {
	private int id;
	private int departmentId;
	private int syllabusId;
	private ZonedDateTime updatedAt;
	
	public DepsylUpdateDTO(int id, int departmentId, int syllabusId) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.syllabusId = syllabusId;
		this.setUpdatedAt(ZonedDateTime.now());
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

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
