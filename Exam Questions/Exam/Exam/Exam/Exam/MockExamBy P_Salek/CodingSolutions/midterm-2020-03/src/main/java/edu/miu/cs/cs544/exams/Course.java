package edu.miu.cs.cs544.exams;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
	private Integer id;
	
	@Column(length = 3, nullable = false)
	private String code; // Maximum of 3 characters, required field
	
	@Column(length = 50, nullable = false)
	private String name; // Maximum of 50 characters, required field
	
	@OneToMany
	private Set<Course> preRequisites = new HashSet<>(); // Set of pre-requisite courses for this course. Can be empty

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getPreRequisites() {
		return preRequisites;
	}

	public void setPreRequisites(Set<Course> preRequisites) {
		this.preRequisites = preRequisites;
	}
	

}
