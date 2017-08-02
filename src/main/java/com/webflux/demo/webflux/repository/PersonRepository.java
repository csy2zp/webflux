package com.webflux.demo.webflux.repository;

import org.springframework.data.repository.CrudRepository;

import com.webflux.demo.webflux.model.Person;

public interface PersonRepository extends CrudRepository<Person, String>{

}
