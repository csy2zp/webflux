package com.webflux.demo.webflux;

import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@ComponentScan({"com.webflux.demo.webflux"})
@EnableTransactionManagement
@Configuration
public class WebfluxApplication {
	
	@Bean
	public MappingJackson2HttpMessageConverter setDateType() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		converter.setObjectMapper(objectMapper);
		return converter;
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);
	}
}
