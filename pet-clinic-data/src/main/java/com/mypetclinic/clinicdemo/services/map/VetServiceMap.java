package com.mypetclinic.clinicdemo.services.map;

import com.mypetclinic.clinicdemo.model.Vet;
import com.mypetclinic.clinicdemo.services.CrudService;

public class VetServiceMap extends AbstractMapService<Vet, Long> 
                             implements CrudService<Vet, Long> {
	@Override
	public Vet save(Vet object) {
		super.save(object.getId(), object);
		return object;
	}

}
