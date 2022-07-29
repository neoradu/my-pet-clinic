package com.mypetclinic.clinicdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnersController {
	
	@RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
	public String index(Model model) {
		return "owners/index";
	}

}
