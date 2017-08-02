package com.webflux.demo.webflux.handler.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.webflux.demo.webflux.handler.IPersonHandler;
import com.webflux.demo.webflux.model.Person;
import com.webflux.demo.webflux.repository.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class PersonHandlerImpl implements IPersonHandler{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Mono<ServerResponse> save(ServerRequest request) {
		return request.bodyToMono(Person.class).flatMap(person->{
			person.setCreateDate(new Date());
			personRepository.save(person);
			return ServerResponse.ok().build();
		});
	}

	@Override
	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ServerResponse.ok().body(Flux.fromIterable(personRepository.findAll()), Person.class);
	}

	@Override
	public Mono<ServerResponse> findOne(ServerRequest request) {
		return ServerResponse.ok().body(Mono.just(personRepository.findById(request.pathVariable("id")).get()), Person.class);
	}

}
