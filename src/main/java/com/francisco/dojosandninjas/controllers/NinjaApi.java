package com.francisco.dojosandninjas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.dojosandninjas.models.Ninja;
import com.francisco.dojosandninjas.services.NinjaService;

@RestController
@RequestMapping("/api")
public class NinjaApi {

	private final NinjaService ninjaServ;

	public NinjaApi(NinjaService ninjaServ) {
		this.ninjaServ = ninjaServ;
	}

	// Create
	@PostMapping("/ninjas")
	public Ninja createDonation(
	        @RequestParam("firstName") String firstName, 
	        @RequestParam("lastName") String lastName,
	        @RequestParam("age") Integer age) {
		Ninja newNinja = new Ninja(
				firstName,
				lastName,
				age);
		return ninjaServ.create(newNinja);
	}

	// Read All
	@GetMapping("/ninjas")
	public List<Ninja> findAllNinja() {
		return ninjaServ.getAll();
	}

	// Read one
	@GetMapping("/ninjas/{id}")
	public Ninja findOneNinja(@PathVariable("id") Long id) {
		return ninjaServ.findOne(id);
	}

	//Update one
	@PutMapping("/ninjas/{id}")
	public Ninja findOneAndUpdate(
        @PathVariable("id") Long id, 
        @RequestParam("firstName") String firstName, 
        @RequestParam("lastName") String lastName,
        @RequestParam("age") Integer age) {
		return ninjaServ.update(
				id, 
				firstName,
				lastName,
				age);
	}

	//Delete 
	@DeleteMapping("/ninjas/{id}")
	public void destroy(@PathVariable("id") Long id) {
		ninjaServ.deleteByID(id);
	}
}