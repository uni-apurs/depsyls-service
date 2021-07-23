package com.apurs.microservices.depsylsservice.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apurs.microservices.depsylsservice.dto.DepsylCreateDTO;
import com.apurs.microservices.depsylsservice.dto.DepsylDTO;
import com.apurs.microservices.depsylsservice.dto.DepsylUpdateDTO;
import com.apurs.microservices.depsylsservice.model.Depsyl;
import com.apurs.microservices.depsylsservice.repository.DepsylRepository;

@Service
public class DepsylServiceImpl implements DepsylService {

	private DepsylRepository depsylRepository;
	
	private RestTemplate restTemplate = new RestTemplate();
	private ModelMapper modelMapper = new ModelMapper();
	
	@Value("${app.departmentsEndpoint}")
	private String departmentsEndpoint;
	
	@Value("${app.syllabusesEndpoint}")
	private String syllabusesEndpoint;
	
	public DepsylServiceImpl(DepsylRepository depsylRepository) {
		this.depsylRepository = depsylRepository;
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Override
	public List<DepsylDTO> findAll() {
		List<Depsyl> depsyls = depsylRepository.findAll();
		List<DepsylDTO> dtos = new ArrayList<DepsylDTO>();
		
		for (Depsyl depsyl : depsyls)
			dtos.add(modelMapper.map(depsyl, DepsylDTO.class));
		
		return dtos;
	}

	@Override
	public DepsylDTO findOne(Integer id) {
		Depsyl depsyl = depsylRepository.getById(id);
		return modelMapper.map(depsyl, DepsylDTO.class);
	}

	@Override
	public DepsylDTO insert(DepsylCreateDTO depsyl) throws Exception {
		ResponseEntity<String> resDepartment = restTemplate.getForEntity(departmentsEndpoint + depsyl.getDepartmentId(), String.class);
		ResponseEntity<String> resSyllabus = restTemplate.getForEntity(syllabusesEndpoint + depsyl.getSyllabusId(), String.class);
		
		if (!resDepartment.getStatusCode().equals(HttpStatus.OK))
			throw new Exception("Invalid departmentId.");
		
		if (!resSyllabus.getStatusCode().equals(HttpStatus.OK))
			throw new Exception("Invalid syllabusId.");
		
		Depsyl createDepsyl = modelMapper.map(depsyl, Depsyl.class);
		createDepsyl = depsylRepository.save(createDepsyl);
		return modelMapper.map(createDepsyl, DepsylDTO.class);
	}

	@Override
	public DepsylDTO update(DepsylUpdateDTO depsyl) throws Exception {
		if (!depsylRepository.existsById(depsyl.getId()))
			return null;
		
		ResponseEntity<String> resDepartment = restTemplate.getForEntity(departmentsEndpoint, String.class);
		ResponseEntity<String> resSyllabus = restTemplate.getForEntity(syllabusesEndpoint, String.class);
		
		if (!resDepartment.getStatusCode().equals(HttpStatus.OK))
			throw new Exception("Invalid departmentId.");
		
		if (!resSyllabus.getStatusCode().equals(HttpStatus.OK))
			throw new Exception("Invalid syllabusId.");
		
		Depsyl tempDepsyl = depsylRepository.getById(depsyl.getId());
		Depsyl updatedDepsyl = modelMapper.map(depsyl, Depsyl.class);
		updatedDepsyl.setCreatedAt(tempDepsyl.getCreatedAt());
		updatedDepsyl = depsylRepository.save(updatedDepsyl);
		return modelMapper.map(updatedDepsyl, DepsylDTO.class); 
	}

	@Override
	public boolean delete(Integer id) {
		if (!depsylRepository.existsById(id))
			return false;
		
		depsylRepository.deleteById(id);
		return true;
	}
}
