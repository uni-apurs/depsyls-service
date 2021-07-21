package com.apurs.microservices.depsylsservice.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.apurs.microservices.depsylsservice.model.Depsyl;
import com.apurs.microservices.depsylsservice.repository.DepsylRepository;

@Service
public class DepsylServiceImpl implements DepsylService {

	private DepsylRepository depsylRepository;
	
	public DepsylServiceImpl(DepsylRepository depsylRepository) {
		this.depsylRepository = depsylRepository;
	}
	
	@Override
	public Collection<Depsyl> findAll() {
		return depsylRepository.findAll();
	}

	@Override
	public Depsyl findOne(Integer id) {
		return depsylRepository.getById(id);
	}

	@Override
	public Depsyl insert(Depsyl depsyl) {
		if (!depsylRepository.existsById(depsyl.getId()))
			return depsylRepository.save(depsyl);
		
		return null;
	}

	@Override
	public boolean update(Depsyl depsyl) {
		if (!depsylRepository.existsById(depsyl.getId()))
			return false;
		
		depsylRepository.save(depsyl);
		return true;
	}

	@Override
	public boolean delete(Integer id) {
		if (!depsylRepository.existsById(id))
			return false;
		
		depsylRepository.deleteById(id);
		return true;
	}
}
