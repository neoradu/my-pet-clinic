package com.mypetclinic.clinicdemo.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mypetclinic.clinicdemo.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
