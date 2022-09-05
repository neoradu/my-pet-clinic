package com.mypetclinic.clinicdemo.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.Pet;
import com.mypetclinic.clinicdemo.model.repositories.PetRepository;
import com.mypetclinic.clinicdemo.services.PetService;


@Service
@Profile({"dev","prod","default"})
public class PetSDJpaService implements PetService{
	final private PetRepository petRepository;
	
	public PetSDJpaService(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> result = new HashSet<Pet>();
		petRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

}
