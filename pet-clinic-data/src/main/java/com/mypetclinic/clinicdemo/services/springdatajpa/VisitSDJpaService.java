package com.mypetclinic.clinicdemo.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.Visit;
import com.mypetclinic.clinicdemo.model.repositories.VisitRepository;
import com.mypetclinic.clinicdemo.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService{
	final private VisitRepository visitRepository;
	
	public VisitSDJpaService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> result = new HashSet<Visit>();
		visitRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}

}
