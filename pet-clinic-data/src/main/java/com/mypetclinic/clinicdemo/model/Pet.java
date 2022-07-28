package com.mypetclinic.clinicdemo.model;

import java.time.LocalDate;

public class Pet {
	private PetType petType;
	private Owner owner;
	private LocalDate birthDate;
	
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
