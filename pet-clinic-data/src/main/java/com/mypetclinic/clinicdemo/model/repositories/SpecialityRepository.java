package com.mypetclinic.clinicdemo.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mypetclinic.clinicdemo.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
