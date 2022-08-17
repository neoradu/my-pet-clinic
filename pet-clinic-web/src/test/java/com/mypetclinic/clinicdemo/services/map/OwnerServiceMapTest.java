package com.mypetclinic.clinicdemo.services.map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mypetclinic.clinicdemo.model.Owner;

public class OwnerServiceMapTest {
	
	private OwnerServiceMap service;
	private Owner savedOwner;
	final Long ownerId = 1L;
	final String lastName = "Gigel";
	
	@BeforeEach
	public void setUpTest() {
		service = new OwnerServiceMap(new PetServiceMap(),
									  new PetTypeServiceMap());
		Owner ouwner = Owner.builder()
							.id(ownerId)
							.lastName(lastName)
							.build();
		
		savedOwner = service.save(ouwner);
	}
	
	@Test
	public void findByIdTest() {
		Owner found = service.findById(ownerId);
		
		assertNotNull(found);
		
	}
	
	@Test
	public void saveWithIdTest() {
		Owner ouwner2 = Owner.builder()
				             .id(ownerId + 1)
				             .lastName(lastName)
				             .build();
		Owner saved = service.save(ouwner2);
		assertNotNull(saved);
		assertEquals(ownerId + 1, saved.getId());
		
	}
	
	@Test
	public void saveWithoutIdTest() {
		Owner ouwner2 = Owner.builder()
				             .lastName(lastName)
				             .build();
		Owner saved = service.save(ouwner2);
		assertNotNull(saved);
		assertNotNull(saved.getId());
		assertEquals(ownerId + 1, saved.getId());
	}
	
	@Test
	public void findAllTest() {
		Set<Owner> owners = service.findAll();
		assertEquals(1, owners.size());
	}
	
	@Test
	public void deleteByObjectTest() {
		service.delete(savedOwner);
		Set<Owner> owners = service.findAll();
		assertEquals(0, owners.size());
		
	}

	
	@Test
	public void deleteByIdTest() {
		service.deleteById(ownerId);
		Set<Owner> owners = service.findAll();
		assertEquals(0, owners.size());	
	}
	
	@Test
	public void findByLastNameTest() {
		Owner ouwner2 = Owner.builder()
	                         .lastName("testteafafaf")
	                         .build();
		service.save(ouwner2);
		
		Owner found = service.findByLastName(lastName);
		
		assertNotNull(found);
		assertEquals(lastName, found.getLastName());
		
		
	}
}
