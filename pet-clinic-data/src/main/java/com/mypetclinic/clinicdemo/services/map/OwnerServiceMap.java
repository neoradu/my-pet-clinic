package com.mypetclinic.clinicdemo.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mypetclinic.clinicdemo.model.Owner;
import com.mypetclinic.clinicdemo.model.Pet;
import com.mypetclinic.clinicdemo.services.OwnerService;
import com.mypetclinic.clinicdemo.services.PetService;
import com.mypetclinic.clinicdemo.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> 
                             implements OwnerService {
	final private PetService petService;
	final private PetTypeService petTypeService;
	
	
	public OwnerServiceMap(PetServiceMap petService, PetTypeServiceMap petTypeService) {
		this.petService = petService;
		this.petTypeService = petTypeService;
	}
	public Owner save(Owner owner) {
		if (owner != null) {
			if (owner.getPets() != null) {
				for(Pet pet : owner.getPets()) {
					if (pet.getPetType() != null && pet.getPetType().getId() == null) {
						petTypeService.save(pet.getPetType());
					}
					if (pet.getId() == null)
						petService.save(pet);
				}
			}
			return super.save(owner);
		} else
			return null;
	}
	@Override
	public Owner findByLastName(String lastName) {
		
		return this.findAll()
				   .stream()
				   .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
				   .findFirst()
				   .orElse(null);
	}

}
