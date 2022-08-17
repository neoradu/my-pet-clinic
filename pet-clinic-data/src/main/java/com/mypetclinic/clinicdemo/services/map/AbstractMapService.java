package com.mypetclinic.clinicdemo.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.mypetclinic.clinicdemo.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
	
	protected Map<Long, T> map = new HashMap<>();
	private Long lastId = null;
	
	private Long getNextId() {
		if(lastId == null) 
			lastId = (long)0;
		else
			lastId++;
		return lastId;
	}
	
	public T findById(ID id) {
		return map.get(id);
	}
	
	public T save(T object) {
		if(object != null) {
			if (object.getId() == null)
				object.setId(getNextId());
			else
				lastId = object.getId();
			
			map.put(object.getId(), object);
		}
		return object;
	}
	
	public Set<T> findAll() {
		return new HashSet<T>(map.values());
	}
	
	public void delete(T object) {
		Long rId = null;
		for(Long i : map.keySet()) {
			if(map.get(i).equals(object)) {
				rId = i;
				break;
			}
		}
		if(rId != null)
			map.remove(rId);
	}
	
	public void deleteById(ID id) {
		map.remove(id);
	}

}
