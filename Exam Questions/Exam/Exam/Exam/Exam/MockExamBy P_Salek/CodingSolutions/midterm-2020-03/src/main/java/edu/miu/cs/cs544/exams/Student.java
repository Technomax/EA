package edu.miu.cs.cs544.exams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Student extends Person {

	private LocalDate entry;

	@OneToMany(mappedBy = "student")
	//@JoinColumn(name = "student_id")
	@OrderColumn(name = "sequence")
	private List<Grade> grades = new ArrayList<>();

	public LocalDate getEntry() {
		return entry;
	}

	public void setEntry(LocalDate entry) {
		this.entry = entry;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

}
