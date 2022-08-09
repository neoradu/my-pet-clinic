package com.mypetclinic.clinicdemo.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass 
//Tells JPA that this is a class that other classes will inherit from
//--> tells not to create a special table for this class in the database
public class BaseEntity implements Serializable {
	@Id//tels JPA that this is the index of the tabble
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//IDENTITY -> Indicates that the persistence provider must assign primary keys
	//for the entity using a database identity column
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
