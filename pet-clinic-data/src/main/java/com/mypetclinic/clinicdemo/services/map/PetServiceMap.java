package com.mypetclinic.clinicdemo.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.Pet;
import com.mypetclinic.clinicdemo.services.PetService;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> 
                           implements PetService {

}
