package com.mypetclinic.clinicdemo.services.map;

import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.Owner;
import com.mypetclinic.clinicdemo.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> 
                             implements OwnerService {

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
