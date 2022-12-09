package com.francisco.dojosandninjas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.dojosandninjas.models.Dojo;
import com.francisco.dojosandninjas.services.DojoService;

@RestController
@RequestMapping("/api")
public class DojoApi {

	private final DojoService dojoServ;

	public DojoApi(DojoService dojoServ) {
		this.dojoServ = dojoServ;
	}

	// Create
	@PostMapping("/dojos")
	public Dojo createDonation( 
	        @RequestParam("name") String name) {
		Dojo newDojo = new Dojo(
				name);
		return dojoServ.create(newDojo);
	}

	// Read All
	@GetMapping("/dojos")
	public List<Dojo> findAllDojo() {
		return dojoServ.getAll();
	}

	// Read one
	@GetMapping("/dojos/{id}")
	public Dojo findOneDojo(@PathVariable("id") Long id) {
		return dojoServ.findOne(id);
	}

	//Update one
//	@PutMapping("/dojos/{id}")
//	public Dojo findOneAndUpdate(
//        @PathVariable("id") Long id, 
//        @RequestParam("dojo") Dojo dojo,
//        @RequestParam("firstName") String firstName, 
//        @RequestParam("lastName") String lastName,
//        @RequestParam("age") Integer age) {
//		return dojoServ.update(
//				id, 
//				dojo, 
//				firstName,
//				lastName,
//				age);
//	}

	//Delete 
	@DeleteMapping("/dojos/{id}")
	public void destroy(@PathVariable("id") Long id) {
		dojoServ.deleteByID(id);
	}
}
