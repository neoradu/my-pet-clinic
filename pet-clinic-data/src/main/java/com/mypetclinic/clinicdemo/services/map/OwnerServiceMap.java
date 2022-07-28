package com.mypetclinic.clinicdemo.services.map;

import com.mypetclinic.clinicdemo.model.Owner;
import com.mypetclinic.clinicdemo.services.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> 
                             implements CrudService<Owner, Long> {
	@Override
	public Owner save(Owner object) {
		super.save(object.getId(), object);
		return object;
	}

}
