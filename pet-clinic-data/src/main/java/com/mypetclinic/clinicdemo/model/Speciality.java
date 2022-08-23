package com.mypetclinic.clinicdemo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.ToString;

@ToString
@Entity//tells JPA that this will be an entity persisted to the database
@Table(name = "specialities")
public class Speciality extends BaseEntity {
	private String desciption;

	public Speciality() {}
	
	@Builder //using Lombok to generate builder pattern https://projectlombok.org/features/Builder
	public Speciality(Long id, String desciption) {
		super(id);
		this.desciption = desciption;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

}
