package com.mypetclinic.clinicdemo.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.Vet;
import com.mypetclinic.clinicdemo.model.repositories.VetRepository;
import com.mypetclinic.clinicdemo.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService{
	final private VetRepository vetRepository;
	
	public VetSDJpaService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> result = new HashSet<Vet>();
		vetRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

}
