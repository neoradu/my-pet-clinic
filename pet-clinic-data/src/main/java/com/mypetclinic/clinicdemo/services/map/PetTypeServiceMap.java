package com.mypetclinic.clinicdemo.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.PetType;
import com.mypetclinic.clinicdemo.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> 
                           implements PetTypeService {

	@Override
	public PetType findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
