package com.mypetclinic.clinicdemo.services;

import com.mypetclinic.clinicdemo.model.Owner;

/**
 * This is a service between controllers and the data sources.
 * This will help easily change the data source.
 * */
public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);

}
