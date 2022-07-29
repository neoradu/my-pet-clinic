package com.mypetclinic.clinicdemo.services.map;

import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.Pet;
import com.mypetclinic.clinicdemo.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> 
                           implements PetService {
	@Override
	public Pet save(Pet object) {
		super.save(object.getId(), object);
		return object;
	}

}
