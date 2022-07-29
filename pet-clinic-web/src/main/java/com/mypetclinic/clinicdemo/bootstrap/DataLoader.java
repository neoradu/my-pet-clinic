package com.mypetclinic.clinicdemo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mypetclinic.clinicdemo.model.Owner;
import com.mypetclinic.clinicdemo.model.Vet;
import com.mypetclinic.clinicdemo.services.OwnerService;
import com.mypetclinic.clinicdemo.services.VetService;
import com.mypetclinic.clinicdemo.services.map.OwnerServiceMap;
import com.mypetclinic.clinicdemo.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {
	
	final VetService vetService;
	final OwnerService ownerService;
	
	DataLoader() {
		//For now init this here. Later will be using Spring Boot provided Beans
		this.ownerService = new OwnerServiceMap();
		this.vetService = new VetServiceMap();
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
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Boostraping data...");
		final String[] personNames = {"Vali", "Georgel", "Ionel", "Bogdan", "Radu", "Alex", "Cosmin"};
		for(int i = 0; i < personNames.length; i++) {
			Owner o = new Owner();
			o.setId((long) i);
			o.setFirstName(personNames[i]);
			o.setLastName(personNames[personNames.length - i -1]);
			ownerService.save(o);
			
			Vet v = new Vet();
			v.setId((long) i);
			v.setFirstName("Dr-" + personNames[i]);
			v.setLastName(personNames[personNames.length - i -1]);
			vetService.save(v);	
		}
		System.out.print(printAllData());
		System.out.println("Boostraping data...END");
		
	}

}
