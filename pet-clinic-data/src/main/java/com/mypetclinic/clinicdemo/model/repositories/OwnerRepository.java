package com.mypetclinic.clinicdemo.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mypetclinic.clinicdemo.model.Owner;

//Because Owner is annotated as a JPA entity, spring data JPA will provide  an implementation at the runtime
public interface OwnerRepository extends CrudRepository<Owner, Long>{

}
