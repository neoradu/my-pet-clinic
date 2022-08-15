package com.mypetclinic.clinicdemo.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.Vet;
import com.mypetclinic.clinicdemo.services.SpecialityService;
import com.mypetclinic.clinicdemo.services.VetService;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> 
                           implements VetService {
	
	private SpecialityService specialityService;
	
	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}
public Vet save(Vet vet) {
		
		if(vet != null) {
			
			if(vet.getSpecialities().size() != 0)
				vet.getSpecialities().forEach(speciality -> {
					if(speciality.getId() == null)
						specialityService.save(speciality);
						
				});
			return super.save(vet);
		}
		else 
			return null;
	}

}
