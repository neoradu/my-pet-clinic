package com.mypetclinic.clinicdemo.model.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.mypetclinic.clinicdemo.model.Owner;

//Because Owner is annotated as a JPA entity, spring data JPA will provide  an implementation at the runtime
public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
	//Querry method. Spring data will parse the method name and deduce what parameter
	//needs to look for in the required object(in this case Owner.lastName).
	//After that will automatically generate a implementation for this interface method definition
	// And use hibernate to fetch data from the data base.
	//One of the coolest features of Spring data JBA
	//https://www.tutorialspoint.com/java8/java8_optional_class.htm
	public Optional<Owner> findByLastName(String lastName);
	
	//Querry method.
	public Optional<Set<Owner>> findAllByLastNameLike(String lastName);
}
