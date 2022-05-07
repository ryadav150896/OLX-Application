package com.zensar.olxmasterapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxmasterapplication.dto.OlxMasterCategoriesDto;
import com.zensar.olxmasterapplication.dto.OlxMasterStatusDto;
import com.zensar.olxmasterapplication.service.OlxMasterService;
//Advertisement categories means 'Real Estate', 'Furniture', 'Electronic goods', 'Vehicles' etc.
@RestController
@RequestMapping("/advertise")
public class Controller {
	
	@Autowired
	private OlxMasterService olxMasterService;
	
	
	//get all categories
	////http:localhost/7070/category
	@GetMapping(value="/category",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<OlxMasterCategoriesDto> getAllAdvCategories(){
		return olxMasterService.getAllAdvCategories();
	}
	
	
	//get all the status
		//http:localhost/7070/status
		@GetMapping(value="/status", produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
		public List<OlxMasterStatusDto> getAllStatus(){
			
			return olxMasterService.getAllStatus();
		}

}
