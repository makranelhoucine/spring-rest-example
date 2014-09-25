package org.myexamples.app.core;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Person extends AbstractEntity {

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
