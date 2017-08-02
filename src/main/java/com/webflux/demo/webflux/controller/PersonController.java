package com.webflux.demo.webflux.controller;

import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webflux.demo.webflux.model.Person;
import com.webflux.demo.webflux.service.IPersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {
	
	private final IPersonService personService;

    public PersonController(IPersonService personService) {
            this.personService = personService;
    }

    @PostMapping("/person")
    Mono<Void> create(@RequestBody Publisher<Person> personStream) {
            return this.personService.save(personStream).then();
    }

    @GetMapping("/person")
    Flux<Person> list() {
            return this.personService.findAll();
    }

    @GetMapping("/person/{id}")
    Mono<Person> findById(@PathVariable String id) {
            return this.personService.findOne(id);
    }
    
}
