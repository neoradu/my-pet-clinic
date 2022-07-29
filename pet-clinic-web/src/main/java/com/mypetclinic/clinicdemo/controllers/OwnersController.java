package com.mypetclinic.clinicdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypetclinic.clinicdemo.services.OwnerService;

@Controller
public class OwnersController {
	final OwnerService ownersService;
	
	public OwnersController(OwnerService ownersService) {
		super();
		this.ownersService = ownersService;
	}

	@RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
	public String index(Model model) {
		model.addAttribute("owners", ownersService.findAll());
		return "owners/index";
	}

}
