package com.mypetclinic.clinicdemo.services;

import com.mypetclinic.clinicdemo.model.Vet;

/**
 * This is a service between controllers and the data sources.
 * This will help easily change the data source.
 * */

public interface VetService extends CrudService<Vet, Long> {

}
