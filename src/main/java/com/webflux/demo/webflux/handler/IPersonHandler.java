package com.webflux.demo.webflux.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface IPersonHandler {
	
	Mono<ServerResponse> save(ServerRequest request);

	Mono<ServerResponse> findAll(ServerRequest request);

	Mono<ServerResponse> findOne(ServerRequest request);
		
}
