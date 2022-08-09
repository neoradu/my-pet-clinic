package com.mypetclinic.clinicdemo.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass//tells JPA that this is a class that will be inherited from.--> no database tables will be created for this
public class Person extends BaseEntity {
	@Column(name = "first_name")// tells JPA how to name the database column
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
