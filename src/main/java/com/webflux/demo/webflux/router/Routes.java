package com.webflux.demo.webflux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.webflux.demo.webflux.handler.IPersonHandler;

@Configuration
public class Routes {
	
	@Autowired
	private IPersonHandler personHandler;
	
	@Bean
	public RouterFunction<ServerResponse> getRouter() {
		return RouterFunctions.route(RequestPredicates.GET("/router/person"),personHandler::findAll)
				.and(RouterFunctions.route(RequestPredicates.POST("/router/person"), personHandler::save))
				.and(RouterFunctions.route(RequestPredicates.GET("/router/person/{id}"), personHandler::findOne));
	}
}
