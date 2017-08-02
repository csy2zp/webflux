package com.webflux.demo.webflux.service.impl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webflux.demo.webflux.model.Person;
import com.webflux.demo.webflux.repository.PersonRepository;
import com.webflux.demo.webflux.service.IPersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class PersonServiceImpl implements IPersonService {
	
	private final static Log logger = LogFactory.getLog(PersonServiceImpl.class);
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Mono<Void> save(Publisher<Person> personStream) {
		personStream.subscribe(new Subscriber<Person>() {

			@Override
			public void onSubscribe(Subscription s) {
				s.request(1);
			}

			@Override
			public void onNext(Person t) {
				t.setCreateDate(new Date());
				personRepository.save(t);
			}

			@Override
			public void onError(Throwable t) {
				logger.error(t.getMessage());
			}

			@Override
			public void onComplete() {
				
			}});
		return Mono.empty();
	}

	@Override
	public Flux<Person> findAll() {
		return Flux.fromIterable(personRepository.findAll());
	}

	@Override
	public Mono<Person> findOne(String id) {
		return Mono.just(personRepository.findById(id).get());
	}

}
