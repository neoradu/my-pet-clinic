package com.mypetclinic.clinicdemo.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypetclinic.clinicdemo.model.Owner;
import com.mypetclinic.clinicdemo.services.OwnerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/owners")
@Controller
public class OwnersController {
	final OwnerService ownersService;
	
	public OwnersController(OwnerService ownersService) {
		super();
		this.ownersService = ownersService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		//WebDataBinder --> binds HTTP objects to a Java object
		//Eg: a http form object that is transformed in a java object.
		//Bellow for security reasons id fields are not allowed to be binded.
		dataBinder.setDisallowedFields("id");
		
	}
	/*
	@GetMapping({"/", "/index", "/index.html",""})
	public String index(Model model) {
		model.addAttribute("owners", ownersService.findAll());
		return "owners/index";
	}*/
	@GetMapping
	public String listOwners(Owner owner, BindingResult result, Model model) {
		//return all owners
		if(owner.getLastName() == null)
			owner.setLastName("");
		
		log.debug( "To find owner by last name:" + owner.getLastName());
		
		Set<Owner> results  = ownersService.findAllByLastName("%" + owner.getLastName() + "%");
		
		if (results.isEmpty()) {
			result.rejectValue("lastName", "Not Found", " not found!");
			return "owners/findOwners";
		} else if (results.size() == 1) {
			Owner foundOwner = results.iterator().next();
			
			model.addAttribute("owner", foundOwner);
			
			log.debug( "Found one owner id:" + foundOwner.getId());
			
			return String.format("redirect:/owners/%d", foundOwner.getId());
		} else {
			model.addAttribute("selections", results);
			return "/owners/ownersList";
		}
			
	}
	
	@GetMapping("/find")
	public String find(Model model) {
		model.addAttribute("owner", new Owner());
		
		return "owners/findOwners";
	}
	
	@GetMapping("/{ownerId}")
	public String displayOwner(@PathVariable String ownerId, Model model) {
	
		Owner owner = ownersService.findById(Long.valueOf(ownerId));
		model.addAttribute("owner", owner);
		
		return "owners/ownerDetails";
	}

}
