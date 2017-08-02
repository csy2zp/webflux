package com.webflux.demo.webflux.service;

import org.reactivestreams.Publisher;

import com.webflux.demo.webflux.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonService {

	Mono<Void> save(Publisher<Person> personStream);

	Flux<Person> findAll();

	Mono<Person> findOne(String id);
}
