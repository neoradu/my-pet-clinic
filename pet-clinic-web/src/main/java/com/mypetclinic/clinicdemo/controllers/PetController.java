package com.mypetclinic.clinicdemo.controllers;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypetclinic.clinicdemo.model.Owner;
import com.mypetclinic.clinicdemo.model.Pet;
import com.mypetclinic.clinicdemo.model.PetType;
import com.mypetclinic.clinicdemo.model.Visit;
import com.mypetclinic.clinicdemo.services.OwnerService;
import com.mypetclinic.clinicdemo.services.PetService;
import com.mypetclinic.clinicdemo.services.PetTypeService;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

	final private PetTypeService petTypeService;
	final private OwnerService ownerService;
	final private PetService petService;
	
	public PetController(PetTypeService petTypeService, OwnerService ownerService,
			             PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.ownerService = ownerService;
		this.petService = petService;
	}
	/*
	 * Annotation that binds a method parameter or method return value to a named model
	 * attribute, exposed to a web view. Supported for controller classes with @RequestMapping methods.*/
	@ModelAttribute("types")
	public Collection<String> populatePetTypes() {
		Collection<String> petTypes =  new HashSet<>();
		
		for(PetType pt : petTypeService.findAll())
			petTypes.add(pt.getName());

		return petTypes;
	}
	
	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable String ownerId) {
		return ownerService.findById(Long.valueOf(ownerId));
	}
	
	/*@InitBinder("owner")
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}*/
	
	@GetMapping("/pets/new")
	public String getNewPet(Model model) {
		Pet newPet = Pet.builder()
						.owner((Owner) model.getAttribute("owner"))
						.build();
		model.addAttribute("pet", newPet);
		
		return "/pets/createOrUpdatePetForm";
	}
	
	@PostMapping("/pets/new")
	public String postNewPet(@Validated Pet pet,
						     @PathVariable String ownerId,
			                 BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "owners/createOrUpdateOwnerForm";
		} else {
			Owner foundOwner = (Owner) model.getAttribute("owner");//= ownerService.findById(Long.valueOf(ownerId));
			PetType petType = petTypeService.findByName(pet.getPetType().getName());
			pet.setPetType(petType);
			
			foundOwner.getPets().add(pet);
			pet.setOwner(foundOwner);
			Owner savedOwner = ownerService.save(foundOwner);
			return "redirect:/owners/" + savedOwner.getId();
		}
	}

	@GetMapping("/pets/{petId}/edit")
	public String getEditPet(@PathVariable String petId, Model model) {
		Pet pet = petService.findById(Long.valueOf(petId));

		model.addAttribute("pet", pet);
		
		return "/pets/createOrUpdatePetForm";
	}
	
	@PostMapping("/pets/{petId}/edit")
	public String postNewPet(@Validated Pet pet,
						     @PathVariable String ownerId,
						     @PathVariable String petId,
			                 BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "owners/createOrUpdateOwnerForm";
		} else {
			Owner foundOwner = (Owner) model.getAttribute("owner");//= ownerService.findById(Long.valueOf(ownerId));

			PetType petType = petTypeService.findByName(pet.getPetType().getName());
			pet.setPetType(petType);
			pet.setOwner(foundOwner);

			petService.save(pet);
			return "redirect:/owners/" + foundOwner.getId();
		}
	}
	
	@GetMapping("/pets/{petId}/visits/new")
	public String getNewVisit(@PathVariable String petId, Model model) {
		Pet pet = petService.findById(Long.valueOf(petId));
		Visit newVisit = Visit.builder()
				              .pet(pet)
				              .build();
		
		model.addAttribute("pet", pet);
		model.addAttribute("visit", newVisit);
		return "/pets/createOrUpdateVisitForm";
	}
	
	@PostMapping("/pets/{petId}/visits/new")
	public String postNewVisit(@Validated Visit visit,
						       @PathVariable String ownerId,
						       @PathVariable String petId,
			                   BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "owners/createOrUpdateVisitForm";
		} else {			
			Pet pet = petService.findById(Long.valueOf(petId));

			visit.setPet(pet);
			pet.getVisits().add(visit);

			petService.save(pet);
			return "redirect:/owners/" + ownerId;
		}
	}
}
