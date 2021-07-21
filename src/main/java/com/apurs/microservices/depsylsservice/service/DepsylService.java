package com.apurs.microservices.depsylsservice.service;

import java.util.Collection;

import com.apurs.microservices.depsylsservice.model.Depsyl;

public interface DepsylService {
	public abstract Collection<Depsyl> findAll();
	public abstract Depsyl findOne(Integer id);
	public abstract Depsyl insert(Depsyl depsyl);
	public abstract boolean update(Depsyl depsyl);
	public abstract boolean delete(Integer id);
}
