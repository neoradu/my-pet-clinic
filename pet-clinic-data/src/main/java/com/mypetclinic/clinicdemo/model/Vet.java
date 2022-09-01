package com.mypetclinic.clinicdemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.ToString;

import javax.persistence.JoinColumn;

@ToString
@Entity
@Table(name = "vets")
public class Vet extends Person {
	
	@ManyToMany(fetch = FetchType.EAGER)//Sets a many to many relationship sets data fetch to eager
	//Creates a Join table that will do the mapping(contains ids on the both side of the relation)
	@JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"),
	inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<Speciality> specialties  = new HashSet<>();;

	public Vet() {}
	
	@Builder //using Lombok to generate builder pattern https://projectlombok.org/features/Builder
	public Vet(Long id, String firstName, String lastName, Set<Speciality> specialities) {
		super(id, firstName, lastName);
		this.specialties = (specialities != null) ? specialities : new HashSet<>();;
	}

	public Set<Speciality> getSpecialities() {
		return specialties;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialties = specialities;
	}
	

}
