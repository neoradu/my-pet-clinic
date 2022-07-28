package com.mypetclinic.clinicdemo.services;

import java.util.Set;

import com.mypetclinic.clinicdemo.model.Vet;

/**
 * This is a service between controllers and the data sources.
 * This will help easily change the data source.
 * */
public interface VetService {
	
	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
}
