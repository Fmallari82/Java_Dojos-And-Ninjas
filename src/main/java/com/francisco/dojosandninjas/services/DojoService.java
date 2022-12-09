package com.francisco.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.francisco.dojosandninjas.models.Dojo;
import com.francisco.dojosandninjas.models.Ninja;
import com.francisco.dojosandninjas.repositories.DojoRepository;
import com.francisco.dojosandninjas.repositories.NinjaRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;

	public DojoService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}

	// returns all the Dojos
	public List<Dojo> getAll() {
		return dojoRepo.findAll();
	}
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}

	// creates a dojo
	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}

	// retrieves a dojo
	public Dojo findOne(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}

	
	public String deleteByID(Long id) {
		dojoRepo.deleteById(id);
		return "you deleted the record with the id of: " + id;
	}

	public Object searchDojo(Long id) {
		Optional<Dojo> potentialDojo =  dojoRepo.findById(id);
		return potentialDojo.isPresent() ? potentialDojo.get() : null;
}
	public Object searchDojo(String name) {
		Optional<Dojo> potentialDojo =  dojoRepo.findByName(name);
		return potentialDojo.isPresent() ? potentialDojo.get() : null;
	}
}
