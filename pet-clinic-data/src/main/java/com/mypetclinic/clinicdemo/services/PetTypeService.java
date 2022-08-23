package com.mypetclinic.clinicdemo.services;

import java.util.Optional;

import com.mypetclinic.clinicdemo.model.PetType;

public interface PetTypeService extends CrudService<PetType, Long> {
	public PetType findByName(String name);
}