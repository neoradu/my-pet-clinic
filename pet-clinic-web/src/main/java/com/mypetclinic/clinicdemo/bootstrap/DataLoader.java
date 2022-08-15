package com.mypetclinic.clinicdemo.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mypetclinic.clinicdemo.model.Owner;
import com.mypetclinic.clinicdemo.model.Pet;
import com.mypetclinic.clinicdemo.model.PetType;
import com.mypetclinic.clinicdemo.model.Speciality;
import com.mypetclinic.clinicdemo.model.Vet;
import com.mypetclinic.clinicdemo.services.OwnerService;
import com.mypetclinic.clinicdemo.services.PetTypeService;
import com.mypetclinic.clinicdemo.services.SpecialityService;
import com.mypetclinic.clinicdemo.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
	
	final VetService vetService;
	final OwnerService ownerService;
	final PetTypeService petTypeService;
	final SpecialityService specialityService;
	
	@Autowired//Not needed but put here because this is a learning project
	public DataLoader(VetService vetService, OwnerService ownerService,
			          PetTypeService petTypeService, SpecialityService specialityService) {
		this.petTypeService = petTypeService;
		this.vetService = vetService;
		this.ownerService = ownerService;
		this.specialityService = specialityService;
	}
	
	private String printAllData() {
		StringBuilder sb = new StringBuilder();
		for(Owner o : ownerService.findAll()) {
			sb.append("Owner-").append(o.getId()).append("-")
			  .append(o.getFirstName()).append(" ")
			  .append(o.getLastName()).append("\n");
		}
		for(Vet v : vetService.findAll()) {
			sb.append("Vet-").append(v.getId()).append("-")
			  .append(v.getFirstName()).append(" ")
			  .append(v.getLastName()).append("\n");
		}
		return sb.toString();	
	}
	private void loadData() {
		System.out.println("Boostraping data...");
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType dog = new PetType();
		dog.setName("Dog");
		petTypeService.save(cat);
		petTypeService.save(dog);
		
		
		final String[] personNames = {"Vali", "Georgel", "Ionel", "Bogdan", "Radu", "Alex", "Cosmin"};
		final String[] specialityes = {"dentist", "taie lemne", "bate cuie"};
		
		for(int i = 0; i < personNames.length; i++) {
			Owner o = new Owner();
			o.setFirstName(personNames[i]);
			o.setLastName(personNames[personNames.length - i -1]);
			o.setAddress("adress-" + i);
			o.setCity("Chiatra");
			o.setTelephone("213208");
			Pet pet = new Pet();
			pet.setPetType(cat);
			pet.setName("miau-" + i);
			pet.setBirthDate(LocalDate.now());
			pet.setOwner(o);
			o.getPets().add(pet);
			ownerService.save(o);
			
			Vet v = new Vet();
			v.setFirstName("Dr-" + personNames[i]);
			v.setLastName(personNames[personNames.length - i -1]);
			Speciality speciality = new Speciality();
			speciality.setDesciption(specialityes[i % specialityes.length]);
			
			specialityService.save(speciality);
			v.getSpecialities().add(speciality);
			vetService.save(v);	
		}
		//System.out.print(printAllData());
		System.out.println("Boostraping data...END");	
	}
	@Override
	public void run(String... args) throws Exception {
		if(petTypeService.findAll().size() == 0)
			loadData();
				
	}

}
