package com.francisco.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.francisco.dojosandninjas.models.Dojo;
import com.francisco.dojosandninjas.models.Ninja;
import com.francisco.dojosandninjas.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	
	private final DojoService dojoServ;
	public DojoController(DojoService dojoServ) {
		this.dojoServ = dojoServ;
	}
	@GetMapping("/{id}")
	public String oneDojo(@PathVariable("id") Long id, Model model) {
		Dojo oneDojo = dojoServ.findOne(id);

		model.addAttribute("dojo", oneDojo);

		return "ninjas/showOne.jsp";
	}
	@GetMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return"dojos/dojoForm.jsp";
	}
	
	@PostMapping("/new")
	public String processNewDojo(
			@Valid @ModelAttribute("dojo") Dojo dojo, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "/dojo/dojoForm.jsp";
		}
		dojoServ.create(dojo);
		
		return "redirect:/dojos/new;";
	}
	
}
