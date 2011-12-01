/**
 * 
 */
package edu.course.hibernate;

/**
 * @author Administrator
 *
 */
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Entity;

@Entity
@SequenceGenerator(name = "TEACHER_SEQ")
public class Teacher extends Person {

	private int seniority;


//	private Long id;
//	@Id
//	@GeneratedValue (strategy=GenerationType.SEQUENCE, generator="TEACHER_SEQ")
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}


}
