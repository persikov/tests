package edu.course.hibernate;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Entity;

@Entity
@SequenceGenerator(name = "COURSE_SEQ")
public class Course {

	private Set<Student> students;
	private Teacher teacher;
	private String name;
	
	public Course() {
		super();
	}
	public Course(Teacher teacher, String name) {
		super();
		this.teacher = teacher;
		this.setName(name);
	}
	private Long id;
	@Id
	@GeneratedValue (strategy=GenerationType.SEQUENCE, generator="COURSE_SEQ")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToMany
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@ManyToOne
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
}
