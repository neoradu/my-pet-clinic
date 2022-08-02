package com.mypetclinic.clinicdemo.services.map;

import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.PetType;
import com.mypetclinic.clinicdemo.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> 
                           implements PetTypeService {

}
