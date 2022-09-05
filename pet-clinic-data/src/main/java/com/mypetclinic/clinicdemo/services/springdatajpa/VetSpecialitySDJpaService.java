package com.mypetclinic.clinicdemo.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.Speciality;
import com.mypetclinic.clinicdemo.model.repositories.SpecialityRepository;
import com.mypetclinic.clinicdemo.services.SpecialityService;


@Service
@Profile({"dev","prod","default"})
public class VetSpecialitySDJpaService implements SpecialityService{
	final private SpecialityRepository specialityRepository;
	
	public VetSpecialitySDJpaService(SpecialityRepository specialityRepository) {
		super();
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		return specialityRepository.save(object);
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> result = new HashSet<Speciality>();
		specialityRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public void delete(Speciality object) {
		specialityRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);
	}

}