package com.mypetclinic.clinicdemo.controllers;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mypetclinic.clinicdemo.model.Owner;
import com.mypetclinic.clinicdemo.services.OwnerService;
//In Java, static import concept is introduced in 1.5 version. With the help of static import,
//we can access the static members of a class directly without class name or any object
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;



import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)//this sets up JUnit5 environment for mockito
public class MockMvcOwnersControllerTest {

	@Mock
	OwnerService ownerService;
	
	@InjectMocks
	OwnersController controller;
	
	Set<Owner>  owners;
	MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		owners = new HashSet<>();
		owners.add(Owner.builder()
				        .id(1L)
				        .lastName("Gigel")
				        .build());
		owners.add(Owner.builder()
		                .id(2L)
		                .lastName("Vasile")
		                .build());
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				                 .build();
			
	}
	@Test
	public void testControllerIndex() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);
		mockMvc.perform(get("/owners"))
		       .andExpect(status().isOk())
		       .andExpect(view().name("owners/index"))
		       .andExpect(model().attributeExists("owners"));
	}
	@Test
	public void testControllerFind() throws Exception {

		mockMvc.perform(get("/owners/find"))
		       .andExpect(status().isOk())
		       .andExpect(view().name("notImplemented"));
	}	
}
