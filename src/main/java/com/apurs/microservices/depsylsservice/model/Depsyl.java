package com.apurs.microservices.depsylsservice.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="\"depsyl\"")
@SequenceGenerator(name = "depsyl_id_seq", initialValue = 1, allocationSize = 1)
public class Depsyl {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "depsyl_id_seq")
	@Column(name="\"id\"")
	private int id;
	
	@Column(name = "\"departmentId\"")
	private int departmentId;
	
	@Column(name = "\"syllabusId\"")
	private int syllabusId;

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
