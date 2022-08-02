package com.mypetclinic.clinicdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypetclinic.clinicdemo.services.VetService;

@Controller
public class VetsController {
	
	private final VetService vetService;
	
	public VetsController(VetService vetService) {
		super();
		this.vetService = vetService;
	}

	@RequestMapping({"/vets", "/vets/index", "/vets/index.html","vets.html"})
	public String index(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}

}
