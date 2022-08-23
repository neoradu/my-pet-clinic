package com.mypetclinic.clinicdemo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.ToString;

@ToString
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {
	private String name;
	
	public PetType() {}
	
	@Builder //using Lombok to generate builder pattern https://projectlombok.org/features/Builder
	public PetType(Long id, String name) {
		super(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
