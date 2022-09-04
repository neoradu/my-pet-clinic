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

import lombok.ToString;

//In Java, static import concept is introduced in 1.5 version. With the help of static import,
//we can access the static members of a class directly without class name or any object
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isNotNull;

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
	
	/*@Test
	public void testIndex() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);
		mockMvc.perform(get("/owners"))
		       .andExpect(status().isOk())
		       .andExpect(view().name("owners/index"))
		       .andExpect(model().attributeExists("owners"));
	}*/
	
	@Test
	public void testDisplayOwner() throws Exception {
		Owner retOwner = Owner.builder()
							  .id(1L)
							  .firstName("TestFirstName")
							  .lastName("last name")
							  .build();
		
		when(ownerService.findById(anyLong())).thenReturn(retOwner);
		
		mockMvc.perform(get("/owners/1"))
		       .andExpect(status().isOk())
		       .andExpect(view().name("owners/ownerDetails"))
		       .andExpect(model().attributeExists("owner"));
	}
	
	@Test
	public void testFindOwner() throws Exception {
		mockMvc.perform(get("/owners/find"))
	       .andExpect(status().isOk())
	       .andExpect(view().name("owners/findOwners"))
	       .andExpect(model().attributeExists("owner"));	
	}
	
	@Test
	public void testDisplayOwners0() throws Exception {
		Set<Owner> zeroOwner = new HashSet<>();
		
		when(ownerService.findAllByLastName(anyString())).thenReturn(zeroOwner);
		
		mockMvc.perform(get("/owners"))
	       .andExpect(status().isOk())
	       .andExpect(view().name("owners/findOwners"));
		
	}
	
	@Test
	public void testDisplayOwners1() throws Exception {
		long id = 1;
		Set<Owner> oneOwner = new HashSet<>();
		oneOwner.add(Owner.builder().id(id).lastName("Gigex").build());
		
		when(ownerService.findAllByLastName(anyString())).thenReturn(oneOwner);
		
		mockMvc.perform(get("/owners"))
	       .andExpect(status().is3xxRedirection())
	       .andExpect(view().name(String.format("redirect:/owners/%d", id)))
		   .andExpect(model().attributeExists("owner"));
		
	}
	
	@Test
	public void testDisplayOwnersMany() throws Exception {
		Set<Owner> twoOwners = new HashSet<>();
		twoOwners.add(Owner.builder().id(1l).lastName("Gigex").build());
		twoOwners.add(Owner.builder().id(2l).lastName("Vasilex").build());
		
		when(ownerService.findAllByLastName(anyString())).thenReturn(twoOwners);
		
		mockMvc.perform(get("/owners"))
	       .andExpect(status().isOk())
	       .andExpect(view().name("owners/ownersList"))
		   .andExpect(model().attributeExists("selections"));
		
	}
	
	@Test
	public void testGetNew() throws Exception {
		mockMvc.perform(get("/owners/new"))
	       .andExpect(status().isOk())
	       .andExpect(view().name("owners/createOrUpdateOwnerForm"))
	       .andExpect(model().attributeExists("owner"));	
	}
	
}
