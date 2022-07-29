package com.mypetclinic.clinicdemo.services.map;

import com.mypetclinic.clinicdemo.model.Owner;
import com.mypetclinic.clinicdemo.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> 
                             implements OwnerService {
	@Override
	public Owner save(Owner object) {
		super.save(object.getId(), object);
		return object;
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
