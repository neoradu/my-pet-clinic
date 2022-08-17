package com.mypetclinic.clinicdemo.services.springdatajpa;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mypetclinic.clinicdemo.model.Owner;
import com.mypetclinic.clinicdemo.model.repositories.OwnerRepository;
import com.mypetclinic.clinicdemo.model.repositories.PetRepository;
import com.mypetclinic.clinicdemo.model.repositories.PetTypeRepository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)//this sets up JUnit5 environment for mockito
public class OwnerSDJpaServiceMockTest {
	
	@Mock
	private OwnerRepository ownerRepository;
	@Mock
	private PetRepository petRepository;
	@Mock
	private PetTypeRepository petTypeRepository;
	
	@InjectMocks
	private OwnerSDJpaService service;
	private Set<Owner> owners;
	private Optional<Owner> ownerOptional;
	
	private Owner retOwner;
	final Long ownerId = 1L;
	
	
	@BeforeEach
	public void setUp() {
		retOwner = Owner.builder()
				        .id(ownerId)
				        .lastName("Gigel")
				        .city("Chiatra")
				        .build();
		ownerOptional = Optional.of(retOwner);
		owners = new HashSet<>();
		owners.add(retOwner);
		
	}
	
	@Test
	public void findByIdTest() {
		//instruct the Mock ownerRepository to return a result when findById is called
		when(ownerRepository.findById(any())).thenReturn(ownerOptional);

		Owner found = service.findById(ownerId);

		assertNotNull(found);
		assertEquals(ownerId, found.getId());
		//verify that findById() is called once
		verify(ownerRepository, times(1)).findById(any());
		
	}
}
