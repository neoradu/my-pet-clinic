package com.mypetclinic.clinicdemo.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mypetclinic.clinicdemo.model.Vet;
import com.mypetclinic.clinicdemo.services.VetService;

@Controller
public class VetsController {
	
	private final VetService vetService;
	
	public VetsController(VetService vetService) {
		super();
		this.vetService = vetService;
	}

	@GetMapping({"/vets", "/vets/index", "/vets/index.html","vets.html"})
	public String index(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
	
	@GetMapping("/api/vets")
	public @ResponseBody Set<Vet> getVetsJson() {
		// this is by default parsed by jackson to JSON
		return vetService.findAll();
	}

}
