package com.mypetclinic.clinicdemo.services.map;

import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.Vet;
import com.mypetclinic.clinicdemo.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> 
                           implements VetService {

}
