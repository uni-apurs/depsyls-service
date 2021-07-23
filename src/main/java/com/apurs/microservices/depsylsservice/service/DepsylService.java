package com.apurs.microservices.depsylsservice.service;

import java.util.List;

import com.apurs.microservices.depsylsservice.dto.DepsylCreateDTO;
import com.apurs.microservices.depsylsservice.dto.DepsylDTO;
import com.apurs.microservices.depsylsservice.dto.DepsylUpdateDTO;

public interface DepsylService {
	public abstract List<DepsylDTO> findAll();
	public abstract DepsylDTO findOne(Integer id);
	public abstract DepsylDTO insert(DepsylCreateDTO depsyl) throws Exception;
	public abstract DepsylDTO update(DepsylUpdateDTO depsyl) throws Exception;
	public abstract boolean delete(Integer id);
}
