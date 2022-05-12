package edu.miu.cs.cs544.exams;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Grade {
	@Id
	private Integer id;
	
	private Double grade;
	
	@ManyToOne
	private Course course;
	
	@ManyToOne
	//@JoinColumn(name="student_id", updatable=false, insertable=false)
	private Student student;

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
