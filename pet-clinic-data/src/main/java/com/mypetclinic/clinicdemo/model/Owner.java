package com.mypetclinic.clinicdemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.ToString;

@ToString
@Entity //JPA entity
@Table(name = "owners")//tels JPA to name this table as "owners" in the database
public class Owner extends Person {
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "telephone")
	private String telephone;
	//Sets a relation oneToMany
	//CascadeType.ALL --> any operation on the parent class(Owner) will cascade  down to the children(Pet)
	//Eg: if we delete an owner the Pet will also get deleted
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();
	
	
	public Owner() { }

	@Builder //using Lombok to generate builder pattern https://projectlombok.org/features/Builder
	public Owner(Long id, String firstName, String lastName, String address,
			     String city, String telephone, Set<Pet> pets) {
		super(id, firstName, lastName);
		this.address = address;
		this.city = city;
		this.telephone = telephone;
		this.pets =  (pets != null) ? pets : new HashSet<>();
	}
	
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getTelephone() {
		return telephone;
	}
	public Set<Pet> getPets() {
		return pets;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	
}
