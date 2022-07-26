package com.mypetclinic.clinicdemo.model.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mypetclinic.clinicdemo.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
	//Querry method. Spring data will parse the method name and deduce what parameter
	//needs to look for in the required object(in this case Owner.lastName).
	//After that will automatically generate a implementation for this interface method definition
	// And use hibernate to fetch data from the data base.
	//One of the coolest features of Spring data JBA
	//https://www.tutorialspoint.com/java8/java8_optional_class.htm
	public Optional<PetType> findByName(String name);	
}
