package com.apurs.microservices.depsylsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apurs.microservices.depsylsservice.dto.DepsylCreateDTO;
import com.apurs.microservices.depsylsservice.dto.DepsylDTO;
import com.apurs.microservices.depsylsservice.dto.DepsylUpdateDTO;
import com.apurs.microservices.depsylsservice.service.DepsylServiceImpl;

@RestController
@RequestMapping("/depsyls")
public class DepsylRestController {
	
	@Autowired
	private DepsylServiceImpl depsylService;
	
	@GetMapping("")
	public List<DepsylDTO> getDepsyls() {
		return depsylService.findAll();
	}
	
	@GetMapping("/{id}")
	public DepsylDTO getDepsyl(@PathVariable("id") Integer id) {
		return depsylService.findOne(id);
	}
	
	@PostMapping("")
	public ResponseEntity<DepsylDTO> insertDepsyl(@RequestBody DepsylCreateDTO depsyl) throws Exception {
		if (depsylService.insert(depsyl) != null)
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("")
	public ResponseEntity<DepsylDTO> updateDepsyl(@RequestBody DepsylUpdateDTO depsyl) throws Exception {
		if (depsylService.update(depsyl) != null)
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<DepsylDTO> deleteDepsyl(@PathVariable("id") Integer id) {
		if (depsylService.delete(id))
			return new ResponseEntity<>(HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
