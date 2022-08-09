package com.mypetclinic.clinicdemo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity//tells JPA that this will be an entity persisted to the database
@Table(name = "specialities")
public class Speciality extends BaseEntity {
	private String desciption;

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

}
