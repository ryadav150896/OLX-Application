package com.zensar.olxapplication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.zensar.olxapplication.entity.UserInformation;

@SpringBootApplication
public class OlxApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxApplication.class, args);
		
		
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


}
