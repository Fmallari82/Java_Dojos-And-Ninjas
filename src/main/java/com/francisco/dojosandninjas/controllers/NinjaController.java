package com.francisco.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.francisco.dojosandninjas.models.Dojo;
import com.francisco.dojosandninjas.models.Ninja;
import com.francisco.dojosandninjas.services.DojoService;
import com.francisco.dojosandninjas.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	
	private final NinjaService ninjaServ;
	private final DojoService dojoServ;
	public NinjaController(NinjaService ninjaServ, DojoService dojoServ) {
		this.ninjaServ = ninjaServ;
		this.dojoServ = dojoServ;
	}
	
	@GetMapping("/all")
	public String allNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("allNinja", ninjaServ.getAll());
		model.addAttribute("ninja", new Ninja());
		return "index.jsp";
	}

	@GetMapping("/{id}")
	public String oneNinja(@PathVariable("id") Long id, Model model) {
		Ninja oneNinja = ninjaServ.findOne(id);
		model.addAttribute("oneNinja", oneNinja );
		return "ninjas/showOne.jsp";
	}
	@GetMapping("/search")
	public String searchNinja(@RequestParam("search") String Search, Model model) {
		model.addAttribute("allNinja", ninjaServ.searchNinja(Search));
		model.addAttribute("ninja", new Ninja());
		return "showOne.jsp";
	}
	
	@GetMapping("/new")
	public String newNinja(
			@ModelAttribute("ninja") Ninja ninja, 
			Model model) {
		List<Dojo> allDojos = dojoServ.getAll();
		model.addAttribute("allDojos", allDojos);
		return "ninjas/ninjaForm.jsp";
	}
	
	@PostMapping("/new/process")
	public String processNinja(
			@Valid 
			@ModelAttribute("ninja") Ninja ninja, 
			BindingResult result,
			Model model) 
	{	
		if(result.hasErrors()) {
			model.addAttribute("allNinja", ninjaServ.getAll());
			return "ninjas/ninjaForm.jsp";
		}
		ninjaServ.create(ninja);
		return "redirect:/ninjas/new";
	
		}
	@GetMapping("/edit/{id}")
		public String editNinja (
				@PathVariable("id") Long id, Model model) {
			Ninja ninjaToBeEdited = ninjaServ.findOne(id);
			model.addAttribute("ninja", ninjaToBeEdited);
			return "edit.jsp";
		}

	@PutMapping("/edit/process/{id}")
	public String processEditNinja(
			@Valid 
			@ModelAttribute("ninja")
			Ninja ninja, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		ninjaServ.update(ninja);
		return "redirect:/ninjas/all";
	
}
	@DeleteMapping("/{id}")
	public String processDelete(@PathVariable("id") Long id) {
		ninjaServ.deleteByID(id);
		return "redirect:/ninjas/all";
	}
}


