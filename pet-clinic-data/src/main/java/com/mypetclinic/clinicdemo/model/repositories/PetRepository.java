package com.mypetclinic.clinicdemo.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mypetclinic.clinicdemo.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
