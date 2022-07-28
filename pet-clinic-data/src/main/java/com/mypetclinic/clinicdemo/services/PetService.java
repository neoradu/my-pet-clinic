package com.mypetclinic.clinicdemo.services;

import java.util.Set;
import com.mypetclinic.clinicdemo.model.Pet;

/**
 * This is a service between controllers and the data sources.
 * This will help easily change the data source.
 * */
public interface PetService extends CrudService<Pet, Long> {

}
