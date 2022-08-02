package com.mypetclinic.clinicdemo.services.map;

import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.Speciality;
import com.mypetclinic.clinicdemo.services.SpecialityService;

@Service
public class SpecialityServiceMap  extends AbstractMapService<Speciality, Long> 
                                   implements SpecialityService {

}
