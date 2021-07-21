package com.apurs.microservices.depsylsservice.dto;

import java.time.ZonedDateTime;

public class DepsylCreateDTO {
	private int departmentId;
	private int syllabusId;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	
	public DepsylCreateDTO(int departmentId, int syllabusId) {
		super();
		this.departmentId = departmentId;
		this.syllabusId = syllabusId;
		this.setCreatedAt(ZonedDateTime.now());
		this.setUpdatedAt(ZonedDateTime.now());
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

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
