package com.zensar.olxadvertiseapplication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.zensar.olxadvertiseapplication.entity.Advertisement;

@SpringBootApplication
public class OlxAdvertiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxAdvertiseApplication.class, args);
}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();

}
}