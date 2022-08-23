package com.mypetclinic.clinicdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypetclinic.clinicdemo.model.Owner;
import com.mypetclinic.clinicdemo.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnersController {
	final OwnerService ownersService;
	
	public OwnersController(OwnerService ownersService) {
		super();
		this.ownersService = ownersService;
	}

	@GetMapping({"/", "/index", "/index.html",""})
	public String index(Model model) {
		model.addAttribute("owners", ownersService.findAll());
		return "owners/index";
	}
	
	@GetMapping("/find")
	public String find() {
		return "notImplemented";
	}
	
	@GetMapping("/{ownerId}")
	public String displayOwner(@PathVariable String ownerId, Model model) {
	
		Owner owner = ownersService.findById(Long.valueOf(ownerId));
		model.addAttribute("owner", owner);
		
		return "owners/ownerDetails";
	}

}
