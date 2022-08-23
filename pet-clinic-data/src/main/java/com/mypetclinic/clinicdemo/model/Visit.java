package com.mypetclinic.clinicdemo.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.ToString;

@ToString
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
	
	@Column(name = "visit_date")
	private LocalDate date;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	
	public Visit() {}
	
	@Builder //using Lombok to generate builder pattern https://projectlombok.org/features/Builder
	public Visit(Long id, LocalDate date, String description, Pet pet) {
		super(id);
		this.date = date;
		this.description = description;
		this.pet = pet;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public String getDescription() {
		return description;
	}
	public Pet getPet() {
		return pet;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	

}
