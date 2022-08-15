package com.mypetclinic.clinicdemo.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.PetType;
import com.mypetclinic.clinicdemo.model.repositories.PetTypeRepository;
import com.mypetclinic.clinicdemo.services.PetTypeService;


@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService{
	final private PetTypeRepository vetRepository;
	
	public PetTypeSDJpaService(PetTypeRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public PetType findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		return vetRepository.save(object);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> result = new HashSet<PetType>();
		vetRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public void delete(PetType object) {
		vetRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

}
