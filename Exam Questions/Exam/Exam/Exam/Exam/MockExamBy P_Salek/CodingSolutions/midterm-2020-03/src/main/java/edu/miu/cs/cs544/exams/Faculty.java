package edu.miu.cs.cs544.exams;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name = "Biography")
public class Faculty extends Person {
	@Column(table = "Biography", length = 2000, nullable = true)
	private String biography; //optional field with a maximum length of 2000 characters

	@ManyToMany
	private Set<Course> courses = new HashSet<>();

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

}
