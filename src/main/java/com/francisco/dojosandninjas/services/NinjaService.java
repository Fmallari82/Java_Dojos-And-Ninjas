package com.francisco.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.francisco.dojosandninjas.models.Dojo;
import com.francisco.dojosandninjas.models.Ninja;
import com.francisco.dojosandninjas.repositories.DojoRepository;
import com.francisco.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	// adding the ninja repository as a dependency
	private final NinjaRepository ninjaRepo;
	private final DojoRepository dojoRepo;

	public NinjaService(NinjaRepository ninjaRepo,DojoRepository dojoRepo) {
		this.ninjaRepo = ninjaRepo;
		this.dojoRepo = dojoRepo;
	}

	// returns all the Ninjas
	public List<Ninja> getAll() {
		return ninjaRepo.findAll();
	}
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}

	// creates a ninja
	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}

	// retrieves a ninja
	public Ninja findOne(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	public Ninja update(
			Long id, 
			String firstName,  
			String lastName,
			Integer age) {
		Ninja ninjaToBeUpdated = new Ninja(id, firstName,lastName,age);
		return ninjaRepo.save(ninjaToBeUpdated);
	}
	
	public Ninja update(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public String deleteByID(Long id) {
		ninjaRepo.deleteById(id);
		return "you deleted the record with the id of: " + id;
	}

	public Object searchNinja(String search) {
		return ninjaRepo.findByfirstNameContaining(search);
}
}

