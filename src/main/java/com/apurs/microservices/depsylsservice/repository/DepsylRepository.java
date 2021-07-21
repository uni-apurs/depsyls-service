package com.apurs.microservices.depsylsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apurs.microservices.depsylsservice.model.Depsyl;


@Repository
public interface DepsylRepository extends JpaRepository<Depsyl, Integer> {

}
