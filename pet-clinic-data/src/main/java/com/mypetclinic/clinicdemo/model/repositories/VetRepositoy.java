package com.mypetclinic.clinicdemo.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mypetclinic.clinicdemo.model.Vet;


public interface VetRepositoy extends CrudRepository<Vet, Long> {

}
