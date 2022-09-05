package com.mypetclinic.clinicdemo.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.Owner;
import com.mypetclinic.clinicdemo.model.repositories.OwnerRepository;
import com.mypetclinic.clinicdemo.model.repositories.PetRepository;
import com.mypetclinic.clinicdemo.model.repositories.PetTypeRepository;
import com.mypetclinic.clinicdemo.services.OwnerService;

@Service
@Profile({"dev","prod","default"})
public class OwnerSDJpaService implements OwnerService {
	
	final private OwnerRepository ownerRepository;
	final private PetRepository petRepository;
	final private PetTypeRepository petTypeRepository;
	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
			                 PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> result = new HashSet<>();
		//https://www.geeksforgeeks.org/double-colon-operator-in-java/
		//Lambda expression
		//ownerRepository.findAll().forEach( o -> result.add(o));
		//Double colon operator
		ownerRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		
		return ownerRepository.findByLastName(lastName).orElse(null);
	}

	@Override
	public Set<Owner> findAllByLastName(String lastName) {

		return ownerRepository.findAllByLastNameLike(lastName)
				              .orElse(new HashSet<Owner>());
	}

}
