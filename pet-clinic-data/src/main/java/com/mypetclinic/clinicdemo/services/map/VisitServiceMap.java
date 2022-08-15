package com.mypetclinic.clinicdemo.services.map;

import com.mypetclinic.clinicdemo.model.Visit;
import com.mypetclinic.clinicdemo.services.VisitService;;

public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
	

	public Visit save(Visit visit) {
		if(visit.getPet() == null || visit.getPet().getId() == null ||
		   visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null)
			throw new RuntimeException("Visit Object invalid!");
		
		return super.save(visit);

	}
}
