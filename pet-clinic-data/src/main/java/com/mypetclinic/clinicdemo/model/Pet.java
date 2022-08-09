package com.mypetclinic.clinicdemo.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
	@Column(name = "name")//redundant but for the demo purpose
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	
	// In the Owner class :@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	@ManyToOne
	@JoinColumn(name = "owner_id")//this tells JPA how to do the mapping at databse level --> we will have a owner_id property in the Pet record
	private Owner owner;// --> this is refers by the mappedBy = "owner"
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits  = new HashSet<>();
	
	
	public Set<Visit> getVisits() {
		return visits;
	}
	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PetType getPetType() {
		return petType;
	}
	public Owner getOwner() {
		return owner;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setPetType(PetType petType) {
		this.petType = petType;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
}
