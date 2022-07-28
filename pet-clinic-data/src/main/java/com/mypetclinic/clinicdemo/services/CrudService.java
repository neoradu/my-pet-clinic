package com.mypetclinic.clinicdemo.services;

import java.util.Set;

public interface CrudService<T, ID> {

	public T findById(ID id);
	
	public T save(T object);
	
	public  Set<T> findAll();
	
	public void delete(T object);
	
	public void deleteById(ID id);
	
}
